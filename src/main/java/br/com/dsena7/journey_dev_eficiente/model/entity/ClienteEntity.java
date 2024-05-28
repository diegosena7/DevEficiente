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
@Table(name="cliente_entity")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String documento; //(cpf/cnpj)@NotBlank

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @OneToOne(mappedBy = "clienteEntity")
    @PrimaryKeyJoinColumn
    private PaisEntity pais;

    @OneToOne
    @PrimaryKeyJoinColumn
    private EstadoEntity estado; //(caso aquele pais tenha estado)

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;
}
