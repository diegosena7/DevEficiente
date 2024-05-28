package br.com.dsena7.journey_dev_eficiente.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ErrorFieldsMsg {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String field;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
