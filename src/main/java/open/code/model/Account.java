package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String regulationAccountType;

    private int ck;

    private String accountCBRBIC;

    private LocalDate dateIn;

    private String accountStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bicDirectoryEntry_id")
    private BicDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccRstrList> accRstrLists;
}