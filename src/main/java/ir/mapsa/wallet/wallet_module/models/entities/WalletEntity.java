package ir.mapsa.wallet.wallet_module.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "wallet")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class WalletEntity extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String walletUser;
    private Long balance;
    @Column(unique = true)
    private Long cardNumber;
    private Long cvv2;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TransactionEntity> transactionEntities;

}
