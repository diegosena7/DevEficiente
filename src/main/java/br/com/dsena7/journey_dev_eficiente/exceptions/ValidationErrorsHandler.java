package br.com.dsena7.journey_dev_eficiente.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Log4j2
public class ValidationErrorsHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseOutputDto> handlerErrorResponse(MethodArgumentNotValidException exception){
        log.error("Exception msg: " + exception.getMessage());
        return ResponseEntity.badRequest().body(ErrorResponseOutputDto.createFromValidation(exception));
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponseOutputDto> handleBusinessException(BusinessException ex) {
        log.error("Exception msg: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponseOutputDto.builder()
                .message(ex.getMessage())
                .build());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseOutputDto> handleBusinessException(DataIntegrityViolationException ex) {
        log.error("Exception msg: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseOutputDto.builder()
                .message(ex.getMessage())
                .build());
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponseOutputDto> sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        log.error("Exception msg: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseOutputDto.builder()
                .message(ex.getMessage())
                .build());
    }
}

