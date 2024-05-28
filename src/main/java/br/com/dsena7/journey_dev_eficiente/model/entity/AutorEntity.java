package br.com.dsena7.journey_dev_eficiente.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="autor_entity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeCriacao;

//    @OneToMany(mappedBy = "autorEntity")
//    private List<LivroEntity> livroEntityId;
}
