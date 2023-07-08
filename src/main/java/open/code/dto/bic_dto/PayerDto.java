package open.code.dto.bic_dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.model.BicDirectoryEntry;
import open.code.model.ParticipantInfo;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayerDto {
    private Long payerId;
    private Long msgId;
    private String bic;
    private String changeType;
    private String nameP;
    private String englName;
    private String regN;
    private String cntrCd;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private String prntBIC;
    private LocalDate dateIn;
    private LocalDate dateOut;
    private String ptType;
    private String srvcs;
    private String xchType;
    private String uid;
    private String participantStatus;

    public PayerDto(BicDirectoryEntry bicDirectoryEntry, ParticipantInfo participantInfo) {
        this.payerId = bicDirectoryEntry.getId();
        this.msgId = bicDirectoryEntry.getBankMessage().getId();
        this.bic = bicDirectoryEntry.getBic();
        this.changeType = String.valueOf(bicDirectoryEntry.getChangeType());
        this.nameP = participantInfo.getNameP();
        this.englName = participantInfo.getEnglName();
        this.regN = participantInfo.getRegN();
        this.cntrCd = participantInfo.getCntrCd();
        this.rgn = participantInfo.getRgn();
        this.ind = participantInfo.getInd();
        this.nnp = participantInfo.getNnp();
        this.adr = participantInfo.getAdr();
        this.prntBIC = participantInfo.getPrntBIC();
        this.dateIn = participantInfo.getDateIn();
        this.dateOut = participantInfo.getDateOut();
        this.ptType = participantInfo.getPtType();
        this.srvcs = participantInfo.getSrvcs();
        this.xchType = participantInfo.getXchType();
        this.uid = participantInfo.getUid();
        this.participantStatus = String.valueOf(participantInfo.getParticipantStatus());
    }
}
