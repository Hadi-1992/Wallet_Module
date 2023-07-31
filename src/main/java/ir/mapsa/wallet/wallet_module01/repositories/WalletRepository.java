package ir.mapsa.wallet.wallet_module01.repositories;

import ir.mapsa.wallet.wallet_module01.models.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByWalletUser(String walletUser);
    WalletEntity findByCardNumber(Long cardNumber);
}
