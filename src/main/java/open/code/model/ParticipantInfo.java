package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ParticipantInfo")
public class ParticipantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute(name = "NameP")
    private String nameP;

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

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateIn")
    private LocalDate dateIn;

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

    @OneToOne
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;
}