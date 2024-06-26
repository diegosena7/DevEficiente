package br.com.dsena7.journey_dev_eficiente.model.entity;

import br.com.dsena7.journey_dev_eficiente.service.AplicaCupomEmCompraService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.ToOne;
import org.springframework.util.Assert;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="compra_entity")
public class CompraEntity {

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
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    private PaisEntity pais;

    @ManyToOne
    private EstadoEntity estado;

    @OneToOne
    @JoinColumn(name = "codigo_cupom", referencedColumnName = "codigo")
    private CupomEntity cupomEntity;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    @Embedded
    private AplicaCupomEmCompraService aplicaCupomEmCompraService;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_id")
    private CarrinhoCompraEntity pedido;

    public void setEstado(EstadoEntity estado) {
        Assert.notNull(pais,"Não rola associar um estado enquanto o pais for nulo");
        Assert.isTrue(estado.pertenceAPais(pais),"Este estado não é do país associado a compra");
        this.estado = estado;
    }
}
