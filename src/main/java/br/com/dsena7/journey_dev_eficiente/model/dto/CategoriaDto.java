package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.CategoriaEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoriaDto {

    private Long id;

    @NotBlank
    private String nome;

    public CategoriaEntity toEntity(CategoriaDto categoriaDto) {
        return CategoriaEntity.builder()
                .nome(categoriaDto.getNome())
                .build();
    }
}
