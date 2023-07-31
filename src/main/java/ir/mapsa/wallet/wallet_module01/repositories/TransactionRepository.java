package ir.mapsa.wallet.wallet_module01.repositories;

import ir.mapsa.wallet.wallet_module01.models.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
