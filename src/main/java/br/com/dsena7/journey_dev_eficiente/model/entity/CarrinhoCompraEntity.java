package br.com.dsena7.journey_dev_eficiente.model.entity;

import br.com.dsena7.journey_dev_eficiente.model.dto.CarrinhoCompraDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.ItensCarrinhoDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="carrinho_compra_entity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarrinhoCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Positive
    private BigDecimal total;

    @Size(min = 1)
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrinho_id")
    private List<ItensCarrinhoEntity> itens = new ArrayList<>();

}
