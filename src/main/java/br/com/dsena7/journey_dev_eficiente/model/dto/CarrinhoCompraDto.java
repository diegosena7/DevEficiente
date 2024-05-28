package br.com.dsena7.journey_dev_eficiente.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
@NoArgsConstructor
@Data
public class CarrinhoCompraDto {

    @NotNull
    @Positive
    private BigDecimal total;

    @Size(min = 1)
    @Valid
    private List<ItensCarrinhoDto> itens = new ArrayList<>();

    public CarrinhoCompraDto(@NotNull @Positive BigDecimal total, @Size(min = 1) @Valid List<ItensCarrinhoDto> itens) {
        this.total = total;
        this.itens = itens;
    }
}
