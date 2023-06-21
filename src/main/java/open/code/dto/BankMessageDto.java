package open.code.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;
import open.code.adapter.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "ED807", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankMessageDto {
    private Long id;
    @NotNull
    private String title;

    @NotNull
    private String fileName;

    private String createdBy;

    @XmlAttribute(name = "EDNo")
    private String eDNo;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "EDDate")
    private LocalDate eDDate;

    @XmlAttribute(name = "EDAuthor")
    private String eDAuthor;

    @XmlAttribute(name = "EDReceiver")
    private String eDReceiver;

    @XmlAttribute(name = "CreationReason")
    private String creationReason;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlAttribute(name = "CreationDateTime")
    private LocalDateTime creationDateTime;

    @XmlAttribute(name = "InfoTypeCode")
    private String infoTypeCode;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "BusinessDay")
    private LocalDate businessDay;

    @XmlAttribute(name = "DirectoryVersion")
    private int directoryVersion;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<BicDirectoryEntryDto> bicDirectoryEntries;
}


/*
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
*/
