package open.code.dto;

import lombok.*;
import open.code.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
public class AccRstrListDto {
    @XmlAttribute(name = "AccRstr")
    private String accRstr;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "AccRstrDate")
    private LocalDate accRstrDate;

    @XmlAttribute(name = "SuccessorBIC")
    private String successorBIC;
}
