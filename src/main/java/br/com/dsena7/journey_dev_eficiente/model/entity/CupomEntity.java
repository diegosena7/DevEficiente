package br.com.dsena7.journey_dev_eficiente.model.entity;

import br.com.dsena7.journey_dev_eficiente.validators.ExistsId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cupom_entity")
public class CupomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Positive
    private BigDecimal percentual;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeValidade;

}
