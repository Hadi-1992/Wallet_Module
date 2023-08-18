package ir.mapsa.wallet.wallet_module.repositories;

import ir.mapsa.wallet.wallet_module.models.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
    List<TransactionEntity> findBySender_WalletUser(String walletSender);
}
