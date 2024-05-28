package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutorResponseDto {

    private String name;
    private String descricao;
    private LocalDate dataDeCriacao;

    public AutorResponseDto(AutorEntity entity) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public AutorEntity toEntityResponse(AutorEntity entity){
        return AutorEntity.builder()
                .dataDeCriacao(entity.getDataDeCriacao())
                .name(entity.getName())
                .descricao(entity.getDescricao())
                .build();
    }
}
