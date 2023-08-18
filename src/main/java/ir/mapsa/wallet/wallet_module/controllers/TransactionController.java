package ir.mapsa.wallet.wallet_module.controllers;

import ir.mapsa.wallet.wallet_module.models.dtoes.TransactionDto;
import ir.mapsa.wallet.wallet_module.models.dtoes.WalletDto;
import ir.mapsa.wallet.wallet_module.models.entities.TransactionEntity;
import ir.mapsa.wallet.wallet_module.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<TransactionEntity, TransactionDto, TransactionService> {

    @GetMapping("/{getTransaction}")
    public List<TransactionDto> getTransaction(@PathVariable String getTransaction) {
        return converter.convertEntity(service.getTransaction(getTransaction));
    }
}
