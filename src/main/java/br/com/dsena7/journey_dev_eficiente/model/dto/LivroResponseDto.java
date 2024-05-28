package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.LivroEntity;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroResponseDto {

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    private LocalDate dataPublicacao;

    private AutorEntity autorEntity;

    public LivroResponseDto(LivroEntity livroEntity) {
    }


    public List<LivroResponseDto> entityToDtoList(List<LivroEntity> entityList){
        ModelMapper modelMapper = new ModelMapper();
        return entityList.stream()
                .map(entidade -> modelMapper.map(entidade, LivroResponseDto.class))
                .collect(Collectors.toList());
    }
}
