package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    @XmlElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccRstrList> accRstrLists;
}