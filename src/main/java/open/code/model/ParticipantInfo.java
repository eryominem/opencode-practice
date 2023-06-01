package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;

@Entity
@XmlRootElement(name = "participantinfo")
@XmlType(propOrder = {"NameP", "CntrCd", "Rgn", "Ind", "Tnp", "Nnp", "Adr", "DateIn", "PtType", "Srvcs", "XchType", "UID", "ParticipantStatus"})
public class ParticipantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameP;

    private String cntrCd;

    private String rgn;

    private String ind;

    private String tnp;

    private String nnp;

    private String adr;

    private LocalDate dateIn;

    private String ptType;

    private String srvcs;

    private String xchType;

    private String UID;

    private String participantStatus;

    @OneToOne
    @JoinColumn(name = "BicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    public ParticipantInfo() {
    }

    public ParticipantInfo(String nameP, String cntrCd, String rgn, String ind, String tnp, String nnp, String adr, LocalDate dateIn,
                           String ptType, String srvcs, String xchType, String UID,
                           String participantStatus, BicDirectoryEntry bicDirectoryEntry) {
        this.nameP = nameP;
        this.cntrCd = cntrCd;
        this.rgn = rgn;
        this.ind = ind;
        this.tnp = tnp;
        this.nnp = nnp;
        this.adr = adr;
        this.dateIn = dateIn;
        this.ptType = ptType;
        this.srvcs = srvcs;
        this.xchType = xchType;
        this.UID = UID;
        this.participantStatus = participantStatus;
        this.bicDirectoryEntry = bicDirectoryEntry;
    }

    public long getId() {
        return id;
    }

    @XmlTransient
    public void setId(long id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    @XmlTransient
    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getCntrCd() {
        return cntrCd;
    }

    @XmlTransient
    public void setCntrCd(String cntrCd) {
        this.cntrCd = cntrCd;
    }

    public String getRgn() {
        return rgn;
    }

    @XmlTransient
    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    @XmlTransient
    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return tnp;
    }

    @XmlTransient
    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getNnp() {
        return nnp;
    }

    @XmlTransient
    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    @XmlTransient
    public void setAdr(String adr) {
        this.adr = adr;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    @XmlTransient
    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public String getPtType() {
        return ptType;
    }

    @XmlTransient
    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public String getSrvcs() {
        return srvcs;
    }

    @XmlTransient
    public void setSrvcs(String srvcs) {
        this.srvcs = srvcs;
    }

    public String getXchType() {
        return xchType;
    }

    @XmlTransient
    public void setXchType(String xchType) {
        this.xchType = xchType;
    }

    public String getUID() {
        return UID;
    }

    @XmlTransient
    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    @XmlTransient
    public void setParticipantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
    }

    public BicDirectoryEntry getBicDirectoryEntry() {
        return bicDirectoryEntry;
    }

    @XmlTransient
    public void setBicDirectoryEntry(BicDirectoryEntry bicDirectoryEntry) {
        this.bicDirectoryEntry = bicDirectoryEntry;
    }
}
