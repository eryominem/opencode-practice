package open.code.dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import open.code.adapter.LocalDateAdapter;
import open.code.enums.RstrType;

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
@XmlRootElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
public class RstrListDto {

    @XmlAttribute(name = "Rstr")
    @Size(min = 4, max = 4)
    private RstrType rstr;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "RstrDate")
    private LocalDate rstrDate;
}
