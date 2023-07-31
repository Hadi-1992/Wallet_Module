package ir.mapsa.wallet.wallet_module01.services;

import ir.mapsa.wallet.wallet_module01.models.entities.TransactionEntity;
import ir.mapsa.wallet.wallet_module01.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService extends AbstractService<TransactionEntity, TransactionRepository> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveTransaction(TransactionEntity transaction) {
        repository.save(transaction);

    }
}




