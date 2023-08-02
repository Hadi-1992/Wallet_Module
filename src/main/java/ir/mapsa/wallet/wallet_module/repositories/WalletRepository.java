package ir.mapsa.wallet.wallet_module.repositories;

import ir.mapsa.wallet.wallet_module.models.entities.TransactionEntity;
import ir.mapsa.wallet.wallet_module.models.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, String> {
    WalletEntity findByWalletUser(String walletUser);

    WalletEntity findByCardNumber(Long cardNumber);

    WalletEntity findAllByWalletUser(String walletUser);
}
