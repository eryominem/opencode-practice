package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@XmlRootElement(name = "ed807")
@XmlType(propOrder = {"EDNo", "EDDate", "EDAuthor", "CreationReason", "CreationDateTime", "InfoTypeCode", "BusinessDay", "DirectoryVersion"})
public class BankMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String eDNo;

    private LocalDate eDDate;

    private String eDAuthor;

    private String creationReason;

    private LocalDateTime creationDateTime;

    private String infoTypeCode;

    private LocalDate businessDay;

    private int directoryVersion;

    @OneToMany(mappedBy = "bicDirectoryEntryId")
    private Set<BicDirectoryEntry> bicDirectoryEntries;

    public BankMessage() {
    }

    public BankMessage(String eDNo, LocalDate eDDate, String eDAuthor, String creationReason, LocalDateTime creationDateTime,
                       String infoTypeCode, LocalDate businessDay, int directoryVersion, Set<BicDirectoryEntry> bicDirectoryEntries) {
        this.eDNo = eDNo;
        this.eDDate = eDDate;
        this.eDAuthor = eDAuthor;
        this.creationReason = creationReason;
        this.creationDateTime = creationDateTime;
        this.infoTypeCode = infoTypeCode;
        this.businessDay = businessDay;
        this.directoryVersion = directoryVersion;
        this.bicDirectoryEntries = bicDirectoryEntries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEDNo() {
        return eDNo;
    }

    @XmlElement
    public void setEDNo(String eDNo) {
        this.eDNo = eDNo;
    }

    public LocalDate getEDDate() {
        return eDDate;
    }

    @XmlElement
    public void setEDDate(LocalDate eDDate) {
        this.eDDate = eDDate;
    }

    public String getEDAuthor() {
        return eDAuthor;
    }

    @XmlElement
    public void setEDAuthor(String eDAuthor) {
        this.eDAuthor = eDAuthor;
    }

    public String getCreationReason() {
        return creationReason;
    }

    @XmlElement
    public void setCreationReason(String creationReason) {
        this.creationReason = creationReason;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @XmlElement
    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getInfoTypeCode() {
        return infoTypeCode;
    }

    @XmlElement
    public void setInfoTypeCode(String infoTypeCode) {
        this.infoTypeCode = infoTypeCode;
    }

    public LocalDate getBusinessDay() {
        return businessDay;
    }

    @XmlElement
    public void setBusinessDay(LocalDate businessDay) {
        this.businessDay = businessDay;
    }

    public int getDirectoryVersion() {
        return directoryVersion;
    }

    @XmlElement
    public void setDirectoryVersion(int directoryVersion) {
        this.directoryVersion = directoryVersion;
    }

    public Set<BicDirectoryEntry> getBicDirectoryEntries() {
        return bicDirectoryEntries;
    }

    @XmlElement
    public void setBicDirectoryEntries(Set<BicDirectoryEntry> bicDirectoryEntries) {
        this.bicDirectoryEntries = bicDirectoryEntries;
    }
}
