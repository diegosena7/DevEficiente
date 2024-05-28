package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.CategoriaEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.LivroEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroDto {

    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(2)
    private Integer numeroDePaginas;

    @NotBlank
    private String isbn;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public LivroEntity toEntity(LivroDto livroDto, AutorEntity autorEntity, CategoriaEntity categoriaEntity){
        return LivroEntity.builder()
                .resumo(livroDto.getResumo())
                .preco(livroDto.getPreco())
                .titulo(livroDto.getTitulo())
                .numeroDePaginas(livroDto.getNumeroDePaginas())
                .sumario(livroDto.getSumario())
                .autorEntity(autorEntity)
                .categoriaEntity(categoriaEntity)
                .isbn(livroDto.getIsbn())
                .dataPublicacao(livroDto.getDataPublicacao())
                .build();
    }
}
