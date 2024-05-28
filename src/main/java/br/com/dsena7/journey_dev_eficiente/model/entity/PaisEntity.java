package br.com.dsena7.journey_dev_eficiente.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pais_entity")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomePais;

    @OneToMany(mappedBy = "paisEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EstadoEntity> estados = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;
}
