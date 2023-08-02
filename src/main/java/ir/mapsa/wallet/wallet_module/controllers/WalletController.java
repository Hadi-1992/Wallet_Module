package ir.mapsa.wallet.wallet_module.controllers;

import ir.mapsa.wallet.wallet_module.exceptionhandlers.exceptions.ServiceException;
import ir.mapsa.wallet.wallet_module.models.dtoes.WalletDto;
import ir.mapsa.wallet.wallet_module.models.entities.TransactionEntity;
import ir.mapsa.wallet.wallet_module.models.entities.WalletEntity;
import ir.mapsa.wallet.wallet_module.models.requests.TransactionRequest;
import ir.mapsa.wallet.wallet_module.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/wallet")
public class WalletController extends AbstractController<WalletEntity, WalletDto, WalletService> {

    @PostMapping("/creat")
    @Transactional
    public void creatWallet(@RequestBody WalletDto walletDto) throws ServiceException {

        service.createWallet(converter.convertDto(walletDto));
    }

    @GetMapping("/{walletUser}")
    public CompletableFuture<ResponseEntity<Object>> sendCardDetails(@PathVariable String walletUser) {
        return service.sendCardDetails(walletUser)
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{walletUser}/{amount}")
    public void updateBalance(@PathVariable String walletUser, @PathVariable Long amount) throws ServiceException {
        service.updateBalance(walletUser, amount);
    }

    @DeleteMapping("/{walletUser}")
    public void deleteWallet(@PathVariable String walletUser) {
        service.deleteWallet(walletUser);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransactionRequest transaction) throws ServiceException {
        service.transfer(transaction);
    }

}
