package br.com.dsena7.journey_dev_eficiente.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="livro_entity")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataPublicacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaEntity categoriaEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private AutorEntity autorEntity;
}
