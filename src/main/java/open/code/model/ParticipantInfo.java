package open.code.model;

import jakarta.persistence.*;
import lombok.*;
import open.code.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute(name = "NameP")
    private String nameP;

    @XmlAttribute(name = "EnglName")
    private String englName;

    @XmlAttribute(name = "RegN")
    private String regN;

    @XmlAttribute(name = "CntrCd")
    private String cntrCd;

    @XmlAttribute(name = "Rgn")
    private String rgn;

    @XmlAttribute(name = "Ind")
    private String ind;

    @XmlAttribute(name = "Tnp")
    private String tnp;

    @XmlAttribute(name = "Nnp")
    private String nnp;

    @XmlAttribute(name = "Adr")
    private String adr;

    @XmlAttribute(name = "PrntBIC")
    private String prntBIC;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateIn")
    private LocalDate dateIn;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateOut")
    private LocalDate dateOut;

    @XmlAttribute(name = "PtType")
    private String ptType;

    @XmlAttribute(name = "Srvcs")
    private String srvcs;

    @XmlAttribute(name = "XchType")
    private String xchType;

    @XmlAttribute(name = "UID")
    private String UID;

    @XmlAttribute(name = "ParticipantStatus")
    private String participantStatus;

    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rstrList_id")
    private RstrList rstrList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;
}