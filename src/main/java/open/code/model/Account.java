package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import open.code.enums.AccountStatusType;
import open.code.enums.AccountType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    @Enumerated(EnumType.STRING)
    private AccountType regulationAccountType;

    private int ck;

    private String accountCBRBIC;

    private LocalDate dateIn;

    @Enumerated(EnumType.STRING)
    private AccountStatusType accountStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccRstrList> accRstrLists;
}