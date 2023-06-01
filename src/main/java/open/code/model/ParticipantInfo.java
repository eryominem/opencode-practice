package open.code.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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

    public void setId(long id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getCntrCd() {
        return cntrCd;
    }

    public void setCntrCd(String cntrCd) {
        this.cntrCd = cntrCd;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public String getPtType() {
        return ptType;
    }

    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public String getSrvcs() {
        return srvcs;
    }

    public void setSrvcs(String srvcs) {
        this.srvcs = srvcs;
    }

    public String getXchType() {
        return xchType;
    }

    public void setXchType(String xchType) {
        this.xchType = xchType;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
    }

    public BicDirectoryEntry getBicDirectoryEntry() {
        return bicDirectoryEntry;
    }

    public void setBicDirectoryEntry(BicDirectoryEntry bicDirectoryEntry) {
        this.bicDirectoryEntry = bicDirectoryEntry;
    }
}
