package open.code.dto.bic_dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import open.code.dto.AccountDto;
import open.code.dto.ParticipantInfoDto;
import open.code.dto.SWBICSDto;
import open.code.enums.ChangeType;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class BicDirectoryEntryDto {
    private Long id;

    @XmlAttribute(name = "BIC")
    @Size(min = 9, max = 9)
    private String bic;

    @XmlAttribute(name = "ChangeType")
    @Size(min = 4, max = 4)
    private ChangeType changeType;

    @XmlElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfoDto participantInfo;

    @XmlElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccountDto> accounts;

    @XmlElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
    private List<SWBICSDto> swbics;
}
