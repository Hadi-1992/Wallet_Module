package ir.mapsa.wallet.wallet_module.aspects;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "wallet")
public class LogModel {
    @MongoId
    private String id;
    private String methodName;
    private Object request;
    private Object response;
    private String errorTrace;

}
