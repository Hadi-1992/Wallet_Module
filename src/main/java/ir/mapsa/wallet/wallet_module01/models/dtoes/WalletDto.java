package ir.mapsa.wallet.wallet_module01.models.dtoes;

import lombok.Data;

@Data
public class WalletDto extends AbstractDto{
    private String walletUser;
    private Long balance;
    private Long cardNumber;
    private Long cvv2;
}
