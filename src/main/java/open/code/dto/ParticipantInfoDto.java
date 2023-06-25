package open.code.dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import open.code.adapter.LocalDateAdapter;
import open.code.enums.ParticipantStatusType;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfoDto {
    private Long id;

    @XmlAttribute(name = "NameP")
    @Size(max = 160)
    private String nameP;

    @XmlAttribute(name = "EnglName")
    @Size(max = 140)
    private String englName;

    @XmlAttribute(name = "RegN")
    @Size(max = 9)
    private String regN;

    @XmlAttribute(name = "CntrCd")
    @Size(min = 2, max = 2)
    private String cntrCd;

    @XmlAttribute(name = "Rgn")
    @Size(max = 2)
    private String rgn;

    @XmlAttribute(name = "Ind")
    @Size(max = 6)
    private String ind;

    @XmlAttribute(name = "Tnp")
    @Size(max = 5)
    private String tnp;

    @XmlAttribute(name = "Nnp")
    @Size(max = 25)
    private String nnp;

    @XmlAttribute(name = "Adr")
    @Size(max = 160)
    private String adr;

    @XmlAttribute(name = "PrntBIC")
    @Size(min = 9, max = 9)
    private String prntBIC;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateIn")
    private LocalDate dateIn;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateOut")
    private LocalDate dateOut;

    @XmlAttribute(name = "PtType")
    @Size(max = 2)
    private String ptType;

    @XmlAttribute(name = "Srvcs")
    @Size(max = 1)
    private String srvcs;

    @XmlAttribute(name = "XchType")
    @Size(max = 1)
    private String xchType;

    @XmlAttribute(name = "UID")
    @Size(min = 10, max = 10)
    private String uid;

    @XmlAttribute(name = "ParticipantStatus")
    @Size(min = 4, max = 4)
    private ParticipantStatusType participantStatus;

    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private RstrListDto rstrList;
}
