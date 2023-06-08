package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.xml.bind.annotation.*;

import java.util.List;

@Entity
@Getter
@Setter
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

    @XmlAttribute(name = "ChangeType")
    private String changeType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participantInfo_id")
    @XmlElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfo participantInfo;

    @XmlElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @XmlElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<SWBICS> swbics;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankMessage_id")
    private BankMessage bankMessage;
}