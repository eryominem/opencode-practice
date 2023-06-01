package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@Entity
@XmlRootElement(name = "accounts")
@XmlType(propOrder = {"Account", "RegulationAccountType", "CK", "AccountCBRBIC", "DateIn", "AccountStatus"})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    private String account;

    private String regulationAccountType;

    private int CK;

    private String accountCBRBIC;

    private LocalDate dateInCreated;

    private String accountStatus;

    @ManyToOne
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntries;

    public Account() {
    }

    public Account(String account, String regulationAccountType, int CK, String accountCBRBIC,
                   LocalDate dateInCreated, String accountStatus, BicDirectoryEntry bicDirectoryEntries) {
        this.account = account;
        this.regulationAccountType = regulationAccountType;
        this.CK = CK;
        this.accountCBRBIC = accountCBRBIC;
        this.dateInCreated = dateInCreated;
        this.accountStatus = accountStatus;
        this.bicDirectoryEntries = bicDirectoryEntries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    @XmlElement
    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegulationAccountType() {
        return regulationAccountType;
    }

    @XmlElement
    public void setRegulationAccountType(String regulationAccountType) {
        this.regulationAccountType = regulationAccountType;
    }

    public int getCK() {
        return CK;
    }

    @XmlElement
    public void setCK(int CK) {
        this.CK = CK;
    }

    public String getAccountCBRBIC() {
        return accountCBRBIC;
    }

    @XmlElement
    public void setAccountCBRBIC(String accountCBRBIC) {
        this.accountCBRBIC = accountCBRBIC;
    }

    public LocalDate getDateInCreated() {
        return dateInCreated;
    }

    @XmlElement
    public void setDateInCreated(LocalDate dateInCreated) {
        this.dateInCreated = dateInCreated;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    @XmlElement
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BicDirectoryEntry getBicDirectoryEntries() {
        return bicDirectoryEntries;
    }

    @XmlElement
    public void setBicDirectoryEntries(BicDirectoryEntry bicDirectoryEntries) {
        this.bicDirectoryEntries = bicDirectoryEntries;
    }
}
