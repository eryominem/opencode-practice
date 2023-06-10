package open.code.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.model.BankMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "title", "createdAt", "fileName",
        "creationDateTime", "edAuthor", "edReceiver", "creationReason",
        "edDate", "infoTypeCode", "businessDay", "directoryVersion", "createdBy"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankMessageDto {
    private Long id;
    private LocalDate createdAt;
    private String title;
    private String fileName;
    private String eDNo;
    private LocalDate eDDate;
    private String eDAuthor;
    private String eDReceiver;
    private String creationReason;
    private LocalDateTime creationDateTime;
    private LocalDate dateAdd;
    private String infoTypeCode;
    private LocalDate businessDay;
    private int directoryVersion;
    private String createdBy;

    public BankMessageDto(BankMessage bankMessage) {
        this.id = bankMessage.getId();
        this.createdAt = bankMessage.getCreatedAt();
        this.title = bankMessage.getTitle();
        this.fileName = bankMessage.getFileName();
        this.eDNo = bankMessage.getEDNo();
        this.eDDate = bankMessage.getEDDate();
        this.eDAuthor = bankMessage.getEDAuthor();
        this.eDReceiver = bankMessage.getEDReceiver();
        this.creationReason = bankMessage.getCreationReason();
        this.creationDateTime = bankMessage.getCreationDateTime();
        this.dateAdd = bankMessage.getCreatedAt();
        this.infoTypeCode = bankMessage.getInfoTypeCode();
        this.businessDay = bankMessage.getBusinessDay();
        this.directoryVersion = bankMessage.getDirectoryVersion();
        this.createdBy = bankMessage.getCreatedBy();
    }
}
