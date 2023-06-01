package open.code.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

@Entity
@XmlRootElement(name = "bicdirectoryentry")
@XmlType(propOrder = {"BIC", "participantinfo", "accounts"})
public class BicDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bicDirectoryEntryId;

    private String BIC;

    @OneToOne
    @JoinColumn(name = "ParticipantInfo_id")
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "accountId")
    private Set<Account> account;

    @ManyToOne
    @JoinColumn(name = "BankMessage_id")
    private BankMessage bankMessage;

    public BicDirectoryEntry() {
    }

    public BicDirectoryEntry(String BIC, ParticipantInfo participantInfo, Set<Account> account, BankMessage bankMessage) {
        this.BIC = BIC;
        this.participantInfo = participantInfo;
        this.account = account;
        this.bankMessage = bankMessage;
    }

    public long getId() {
        return bicDirectoryEntryId;
    }


    public void setId(long bicDirectoryEntryId) {
        this.bicDirectoryEntryId = bicDirectoryEntryId;
    }

    public String getBIC() {
        return BIC;
    }

    @XmlElement
    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public ParticipantInfo getParticipantInfo() {
        return participantInfo;
    }

    @XmlElement
    public void setParticipantInfo(ParticipantInfo participantInfo) {
        this.participantInfo = participantInfo;
    }

    public Set<Account> getAccount() {
        return account;
    }

    @XmlElement
    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    public BankMessage getBankMessage() {
        return bankMessage;
    }

    @XmlElement
    public void setBankMessage(BankMessage bankMessage) {
        this.bankMessage = bankMessage;
    }
}
