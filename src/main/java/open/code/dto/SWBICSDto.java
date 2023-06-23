package open.code.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
public class SWBICSDto {
    private Long id;

    @XmlAttribute(name = "SWBIC")
    @Size(max = 11)
    private String swbic;

    @XmlAttribute(name = "DefaultSWBIC")
    private boolean defaultSWBIC;
}
