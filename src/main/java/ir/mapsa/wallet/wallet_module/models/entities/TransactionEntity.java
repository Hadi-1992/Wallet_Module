package ir.mapsa.wallet.wallet_module.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.Date;

@Entity
@Data
@Table(name = "transaction")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class TransactionEntity extends AbstractEntity {

    private Date date;
    private Long amount;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private WalletEntity sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private WalletEntity receiver;
}
