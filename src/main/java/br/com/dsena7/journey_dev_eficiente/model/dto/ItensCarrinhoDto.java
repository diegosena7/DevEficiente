package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.LivroEntity;
import br.com.dsena7.journey_dev_eficiente.validators.ExistsId;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@Data
public class ItensCarrinhoDto {

    @NotNull
    @ExistsId(domainClass = LivroEntity.class, fieldName = "id")
    private Long idLivro;

    @Positive
    private Integer quantidade;

    public ItensCarrinhoDto(@NotNull Long idLivro, @Positive Integer quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }
}
