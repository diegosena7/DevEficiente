package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.CupomEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import br.com.dsena7.journey_dev_eficiente.service.CompraService;
import br.com.dsena7.journey_dev_eficiente.validators.ExistsId;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CupomRequestDto {

    @NotNull
    private String codigo;

    @Positive
    private BigDecimal percentual;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Future
    @NotNull
    private LocalDate dataDeValidade;

    @ExistsId(domainClass = CompraEntity.class, fieldName = "id")
    private Long idCompra;
}
