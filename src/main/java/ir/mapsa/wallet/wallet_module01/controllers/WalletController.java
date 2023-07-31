package ir.mapsa.wallet.wallet_module01.controllers;

import ir.mapsa.wallet.wallet_module01.exceptionhandlers.exceptions.ServiceException;
import ir.mapsa.wallet.wallet_module01.models.dtoes.WalletDto;
import ir.mapsa.wallet.wallet_module01.models.entities.WalletEntity;
import ir.mapsa.wallet.wallet_module01.models.requests.TransactionRequest;
import ir.mapsa.wallet.wallet_module01.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/wallet")
public class WalletController extends AbstractController<WalletEntity, WalletDto, WalletService> {

    @PostMapping("/create")
    @Transactional
    public void creatWallet(@RequestBody WalletDto walletDto) throws ServiceException {

        service.createWallet(converter.convertDto(walletDto));
    }

    @GetMapping("/{walletUser}")
    public CompletableFuture<ResponseEntity<Object>> sendCardDetails(@PathVariable("walletUser") String walletUser) throws ServiceException {
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
