package br.com.dsena7.journey_dev_eficiente.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ErrorResponseOutputDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<ErrorFieldsMsg> fieldsMsgs;

    public static ErrorResponseOutputDto createFromValidation(MethodArgumentNotValidException methodArgumentNotValidException) {
        var violations =
                methodArgumentNotValidException
                        .getFieldErrors()
                        .stream()
                        .map(fieldError -> new ErrorFieldsMsg(fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList());
        return new ErrorResponseOutputDto("Validation Errors", violations);
    }
}
