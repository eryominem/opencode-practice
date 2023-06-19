package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameP;

    private String englName;

    private String regN;

    private String cntrCd;

    private String rgn;

    private String ind;

    private String tnp;

    private String nnp;

    private String adr;

    private String prntBIC;

    private LocalDate dateIn;

    private LocalDate dateOut;

    private String ptType;

    private String srvcs;

    private String xchType;

    private String uid;

    private String participantStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rstrList_id")
    private RstrList rstrList;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;
}