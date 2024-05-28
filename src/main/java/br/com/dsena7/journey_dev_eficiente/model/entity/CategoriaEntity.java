package br.com.dsena7.journey_dev_eficiente.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categoria_entity")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaEntity")
//    private List<LivroEntity> livroEntity;
}
