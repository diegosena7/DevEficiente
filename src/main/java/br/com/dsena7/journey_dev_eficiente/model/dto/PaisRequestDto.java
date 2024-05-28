package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaisRequestDto {

    private Long id;

    @NotBlank
    private String nomePais;

    public PaisEntity toEntity(PaisRequestDto dto){
        return PaisEntity.builder()
                .nomePais(dto.getNomePais())
                .build();
    }
}
