package open.code.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute(name = "Account")
    private String account;

    @XmlAttribute(name = "RegulationAccountType")
    private String regulationAccountType;

    @XmlAttribute(name = "CK")
    private int CK;

    @XmlAttribute(name = "AccountCBRBIC")
    private String accountCBRBIC;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateIn")
    private LocalDate dateIn;

    @XmlAttribute(name = "AccountStatus")
    private String accountStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;
}