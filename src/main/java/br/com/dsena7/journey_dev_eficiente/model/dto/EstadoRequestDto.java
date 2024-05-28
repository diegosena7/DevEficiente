package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.EstadoEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoRequestDto {

    private Long id;

    @NotBlank
    private String nomeEstado;

    @NotNull
    private Long idPais;

    public EstadoEntity toEntity(EstadoRequestDto dto, PaisEntity paisEntity){
        return EstadoEntity.builder()
                .paisEntity(paisEntity)
                .nomeEstado(dto.getNomeEstado())
                .build();
    }
}
