package ir.mapsa.wallet.wallet_module.services;

import ir.mapsa.wallet.wallet_module.exceptionhandlers.exceptions.ServiceException;
import ir.mapsa.wallet.wallet_module.models.entities.TransactionEntity;
import ir.mapsa.wallet.wallet_module.models.entities.WalletEntity;
import ir.mapsa.wallet.wallet_module.models.requests.TransactionRequest;
import ir.mapsa.wallet.wallet_module.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class WalletService extends AbstractService<WalletEntity, WalletRepository> {
    @Autowired
    TransactionService transactionService;

    public void createWallet(WalletEntity walletEntity) {

        walletEntity.setCardNumber((long) (Math.random() * 10000L));
        walletEntity.setCvv2((long) (Math.random() * 1000L));
        repository.save(walletEntity);

    }

    @Async
    public CompletableFuture<Object> sendCardDetails(String walletUser) {
        WalletEntity wallet = repository.findByWalletUser(walletUser).get(0);

//        if (wallet != null) {
        Long cardNumber = wallet.getCardNumber();
        Long cvv2 = wallet.getCvv2();
        Long balance = wallet.getBalance();

        String message = "card number: " + cardNumber + "\nCVV2: " + cvv2 + "\nbalance: " + balance;
        return CompletableFuture.completedFuture(message);
//        } else {
//
//            return CompletableFuture.completedFuture("card not found");
//        }
    }

    public void updateBalance(String walletUser, Long amount) throws ServiceException {
        WalletEntity wallet = repository.findByWalletUser(walletUser).get(0);
        if (wallet != null) {
            Long currentBalance = wallet.getBalance();
            wallet.setBalance(currentBalance + amount);
            repository.save(wallet);
        } else {
            throw new ServiceException("Wallet not found for user: " + walletUser);
        }
    }

    public void deleteWallet(String walletUser) {
        WalletEntity walletEntity = repository.findByWalletUser(walletUser).get(0);
        repository.delete(walletEntity);
    }

    @Async
    public void transfer(TransactionRequest transactionRequest) throws ServiceException {
        TransactionEntity transactionEntity = new TransactionEntity();
        WalletEntity walletSender = repository.findByCardNumber(transactionRequest.getSenderCardNumber());
        if (walletSender.getBalance() < transactionRequest.getAmount()) {
            throw new ServiceException("Insufficient inventory");
        }
        if (walletSender != null) {
            walletSender.setBalance(walletSender.getBalance() - transactionRequest.getAmount());
        } else throw new ServiceException("wallet not found");
        repository.save(walletSender);

        WalletEntity walletReceiver = repository.findByCardNumber(transactionRequest.getReceiverCardNumber());
        if (walletReceiver != null) {
            walletReceiver.setBalance(walletReceiver.getBalance() + transactionRequest.getAmount());
        } else throw new ServiceException("wallet not found");
        repository.save(walletReceiver);

        transactionEntity.setAmount(transactionRequest.getAmount());
        transactionEntity.setReceiver(walletReceiver);
        transactionEntity.setSender(walletSender);
        transactionEntity.setDate(new Date());
        transactionService.saveTransaction(transactionEntity);
    }
}