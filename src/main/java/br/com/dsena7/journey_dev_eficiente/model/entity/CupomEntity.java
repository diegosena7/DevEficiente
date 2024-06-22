package br.com.dsena7.journey_dev_eficiente.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "cupom_entity")
public class CupomEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(nullable = false, unique = true)
    private String codigo;

    @Positive
    private BigDecimal percentual;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeValidade;

}
