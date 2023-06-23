package open.code.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
public class AccountDto {

    @XmlAttribute(name = "Account")
    @Size(min = 20, max = 20)
    private String account;

    @XmlAttribute(name = "RegulationAccountType")
    @Size(min = 4, max = 4)
    private String regulationAccountType;

    @XmlAttribute(name = "CK")
    @Digits(integer = 2, fraction = 0)
    private int ck;

    @XmlAttribute(name = "AccountCBRBIC")
    @Size(min = 9, max = 9)
    private String accountCBRBIC;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateIn")
    private LocalDate dateIn;

    @XmlAttribute(name = "AccountStatus")
    @Size(min = 4, max = 4)
    private String accountStatus;

    @XmlElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccRstrListDto> accRstrLists;
}
