package open.code.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BicDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String BIC;

    @OneToOne
    @JoinColumn(name = "ParticipantInfo_id")
    private ParticipantInfo participantInfo;

    @OneToMany
    @JoinColumn(name = "account_id")
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
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public ParticipantInfo getParticipantInfo() {
        return participantInfo;
    }

    public void setParticipantInfo(ParticipantInfo participantInfo) {
        this.participantInfo = participantInfo;
    }

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    public BankMessage getBankMessage() {
        return bankMessage;
    }

    public void setBankMessage(BankMessage bankMessage) {
        this.bankMessage = bankMessage;
    }
}
