package br.com.dsena7.journey_dev_eficiente.service;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AplicaCupomEmCompraService {

    private BigDecimal percentualDeDesconto;
    private LocalDate validade;
}
