package open.code.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.model.BankMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class BankMsgViewDto {
    private Long id;
    private String title;
    private LocalDate createdAt;
    private String fileName;
    private LocalDate eDDate;
    private String eDAuthor;
    private String eDReceiver;
    private String creationReason;
    private LocalDateTime creationDateTime;
    private String infoTypeCode;
    private LocalDate businessDay;
    private int directoryVersion;
    private String createdBy;


    public static BankMsgViewDto build(BankMessage bankMessage) {
        var bankMsgViewDto = BankMsgViewDto.builder()
                .id(bankMessage.getId())
                .title(bankMessage.getTitle())
                .createdAt(bankMessage.getCreatedAt())
                .fileName(bankMessage.getFileName())
                .eDDate(bankMessage.getEDDate())
                .eDAuthor(bankMessage.getEDAuthor())
                .eDReceiver(bankMessage.getEDReceiver())
                .creationReason(String.valueOf(bankMessage.getCreationReason()))
                .creationDateTime(bankMessage.getCreationDateTime())
                .infoTypeCode(String.valueOf(bankMessage.getInfoTypeCode()))
                .businessDay(bankMessage.getBusinessDay())
                .directoryVersion(bankMessage.getDirectoryVersion())
                .createdBy(bankMessage.getCreatedBy())
                .build();
        return bankMsgViewDto;
    }
}
