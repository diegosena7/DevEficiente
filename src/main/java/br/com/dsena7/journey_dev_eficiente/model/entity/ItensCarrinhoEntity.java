package br.com.dsena7.journey_dev_eficiente.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="itens_carrrinho_entity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItensCarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idLivro;

    @Positive
    @Column(nullable = false)
    private Integer quantidade;
}
