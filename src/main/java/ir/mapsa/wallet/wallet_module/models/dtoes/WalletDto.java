package ir.mapsa.wallet.wallet_module.models.dtoes;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class WalletDto extends AbstractDto {
//    @Pattern(regexp =  "\\d{3}" , message = "Wallet user Must Have at least 3 Digit")
    private String walletUser;
    private Long balance;
    private Long cardNumber;
    private Long cvv2;
}
