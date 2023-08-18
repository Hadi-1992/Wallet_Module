package ir.mapsa.wallet.wallet_module.models.dtoes;

import ir.mapsa.wallet.wallet_module.models.entities.WalletEntity;
import lombok.Data;

import java.util.Date;
@Data
public class TransactionDto extends AbstractDto{
    private Date date;
    private Long amount;
    private WalletEntity sender;
    private WalletEntity receiver;
}
