package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class BicDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute(name = "BIC")
    private String BIC;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participantInfo_id")
    @XmlElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfo participantInfo;

    @XmlElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankMessage_id")
    private BankMessage bankMessage;
}