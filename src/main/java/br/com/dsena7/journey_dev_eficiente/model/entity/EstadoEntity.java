package br.com.dsena7.journey_dev_eficiente.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="estado_entity")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomeEstado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pais_id") @NotNull @Valid
    private PaisEntity paisEntity;

//    @OneToOne
//    private ClienteEntity clienteEntity;

    public boolean pertenceAPais(PaisEntity pais) {
        return this.paisEntity.equals(pais);
    }
}
