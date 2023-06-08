package open.code.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryDto {
    private String code;
    private String name;
    private LocalDate validityStart;
    private LocalDate validityEnd;
}
