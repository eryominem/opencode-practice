package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "BICDirectoryEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class BicDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute(name = "BIC")
    private String BIC;

    @OneToOne
    @JoinColumn(name = "participantInfo_id")
    @XmlElement(name = "ParticipantInfo")
    private ParticipantInfo participantInfo;

    @XmlElementWrapper(name = "Accounts")
    @XmlElement(name = "Account")
    @OneToMany(mappedBy = "bicDirectoryEntry")
    private Set<Account> account;

    @ManyToOne
    @JoinColumn(name = "bankMessage_id")
    private BankMessage bankMessage;
}