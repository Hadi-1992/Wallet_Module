package ir.mapsa.wallet.wallet_module.models.dtoes;

import lombok.Data;

import java.util.Date;

@Data
public class AbstractDto {
    private String Id;

    private Long version;

    private Date insertTimeStamp;

    private Date lastUpdateTimeStamp;
}
