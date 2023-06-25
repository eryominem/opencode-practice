package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import open.code.enums.ChangeType;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BicDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bic;

    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participantInfo_id")
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<SWBICS> swbics;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankMessage_id")
    private BankMessage bankMessage;
}