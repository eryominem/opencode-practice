package open.code.exception;

import lombok.extern.log4j.Log4j2;
import open.code.exception.bankmsg_exception.BankMessageNotFoundException;
import open.code.exception.bic_exception.BicEntryNotFoundException;
import open.code.exception.directory_exception.DirectoryException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        CustomErrorMessage body = CustomErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .cause(ExceptionUtils.getRootCauseMessage(ex))
                .trace(ExceptionUtils.getStackTrace(ex))
                .build();
        log.error(ex);
        return  new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        CustomErrorMessage body = CustomErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .cause(ExceptionUtils.getRootCauseMessage(ex))
                .trace(ExceptionUtils.getStackTrace(ex))
                .build();
        log.error(ex);
        return  new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DirectoryException.class)
    public ResponseEntity<?> handleDirectoryException(DirectoryException ex) {
        CustomErrorMessage body = CustomErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .cause(ExceptionUtils.getRootCauseMessage(ex))
                .trace(ExceptionUtils.getStackTrace(ex))
                .build();
        log.error(ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BankMessageNotFoundException.class)
    public ResponseEntity<?> handleBankMessageNotFoundException(BankMessageNotFoundException ex) {
        CustomErrorMessage body = CustomErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .cause(ExceptionUtils.getRootCauseMessage(ex))
                .trace(ExceptionUtils.getStackTrace(ex))
                .build();
        log.error(ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BicEntryNotFoundException.class)
    public ResponseEntity<?> handleBicEntryNotFoundException(BicEntryNotFoundException ex) {
        CustomErrorMessage body = CustomErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .cause(ExceptionUtils.getRootCauseMessage(ex))
                .trace(ExceptionUtils.getStackTrace(ex))
                .build();
        log.error(ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
