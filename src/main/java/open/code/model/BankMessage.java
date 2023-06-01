package open.code.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
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

    @OneToMany
    @JoinColumn(name = "BicDirectoryEntry_id")
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

    public void setEDNo(String eDNo) {
        this.eDNo = eDNo;
    }

    public LocalDate getEDDate() {
        return eDDate;
    }

    public void setEDDate(LocalDate eDDate) {
        this.eDDate = eDDate;
    }

    public String getEDAuthor() {
        return eDAuthor;
    }

    public void setEDAuthor(String eDAuthor) {
        this.eDAuthor = eDAuthor;
    }

    public String getCreationReason() {
        return creationReason;
    }

    public void setCreationReason(String creationReason) {
        this.creationReason = creationReason;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getInfoTypeCode() {
        return infoTypeCode;
    }

    public void setInfoTypeCode(String infoTypeCode) {
        this.infoTypeCode = infoTypeCode;
    }

    public LocalDate getBusinessDay() {
        return businessDay;
    }

    public void setBusinessDay(LocalDate businessDay) {
        this.businessDay = businessDay;
    }

    public int getDirectoryVersion() {
        return directoryVersion;
    }

    public void setDirectoryVersion(int directoryVersion) {
        this.directoryVersion = directoryVersion;
    }

    public Set<BicDirectoryEntry> getBicDirectoryEntries() {
        return bicDirectoryEntries;
    }

    public void setBicDirectoryEntries(Set<BicDirectoryEntry> bicDirectoryEntries) {
        this.bicDirectoryEntries = bicDirectoryEntries;
    }
}
