package ir.mapsa.wallet.wallet_module.services;

import ir.mapsa.wallet.wallet_module.models.entities.TransactionEntity;
import ir.mapsa.wallet.wallet_module.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService extends AbstractService<TransactionEntity, TransactionRepository> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveTransaction(TransactionEntity transaction) {
        repository.save(transaction);

    }

}




