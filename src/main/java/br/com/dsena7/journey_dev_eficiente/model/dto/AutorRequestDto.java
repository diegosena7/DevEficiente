package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutorRequestDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeCriacao;

    public AutorEntity toEntity(AutorRequestDto dto){
        return AutorEntity.builder()
                .dataDeCriacao(dto.getDataDeCriacao())
                .email(dto.getEmail())
                .name(dto.getName())
                .descricao(dto.getDescricao())
                .build();
    }
}
