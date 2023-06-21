package open.code.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CustomErrorMessage {
    private String message;
    private LocalDateTime timestamp;
    private Integer status;
    private String cause;
    private String trace;
}
