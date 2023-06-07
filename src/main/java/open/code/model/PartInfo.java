package open.code.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "PartInfo", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partNo;

    private String partQuantity;

    private String partAggregateID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankMessage_id")
    private BankMessage bankMessage;
}
