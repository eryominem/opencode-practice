package open.code.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;
import open.code.adapter.LocalDateTimeAdapter;
import open.code.enums.ReasonCodeType;
import open.code.enums.RequestCodeType;
import org.hibernate.validator.constraints.Length;

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

    @NotNull
    private String createdBy;

    @XmlAttribute(name = "EDNo")
    @Size(max = 9)
    private String eDNo;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "EDDate")
    private LocalDate eDDate;

    @XmlAttribute(name = "EDAuthor")
    @Size(min = 10, max = 10)
    private String eDAuthor;

    @XmlAttribute(name = "EDReceiver")
    @Size(min = 10, max = 10)
    private String eDReceiver;

    @XmlAttribute(name = "CreationReason")
    @Size(min = 4, max = 4)
    private ReasonCodeType creationReason;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlAttribute(name = "CreationDateTime")
    private LocalDateTime creationDateTime;

    @XmlAttribute(name = "InfoTypeCode")
    @Size(min = 4, max = 4)
    private RequestCodeType infoTypeCode;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "BusinessDay")

    private LocalDate businessDay;

    @XmlAttribute(name = "DirectoryVersion")
    @Digits(integer = 2, fraction = 0)
    private int directoryVersion;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    private List<BicDirectoryEntryDto> bicDirectoryEntries;
}

