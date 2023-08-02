package ir.mapsa.wallet.wallet_module.models.requests;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long senderCardNumber;
    private Long senderCvv2;
    private Long receiverCardNumber;
    private Long receiverCvv2;
    private Long amount;
}
