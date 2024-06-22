package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.CupomEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.EstadoEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import br.com.dsena7.journey_dev_eficiente.validators.CepValid;
import br.com.dsena7.journey_dev_eficiente.validators.ExistsId;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Builder
@ToString
@NoArgsConstructor
@Data
public class CompraDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CPF
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(domainClass = PaisEntity.class, fieldName = "id")
    private Long idPais;

    @NotNull
    @ExistsId(domainClass = EstadoEntity.class, fieldName = "id")
    private Long idEstado;

    @Pattern(regexp = "\\d{10,14}", message = "O telefone deve ter entre 10 e 14 dígitos.")
    @NotBlank
    private String telefone;

    @NotBlank
    @CepValid
    private String cep;

    @Valid
    @NotNull
    private CarrinhoCompraDto pedido;

    private String codigoCupom;

    public CompraDto(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @CPF @CNPJ String documento,
                     @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado,
                     @NotBlank String telefone, @NotBlank String cep, @NotNull CarrinhoCompraDto pedido, String codigoCupom) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
        this.codigoCupom = codigoCupom;
    }

    public CompraEntity toEntity(EntityManager entityManager, CupomEntity cupom){
        @NotNull PaisEntity pais = entityManager.find(PaisEntity.class, idPais);
        EstadoEntity estado;

        CompraEntity compraEntity = CompraEntity.builder()
                .pais(pais)
                .cep(cep)
                .cidade(cidade)
                .nome(nome).sobrenome(sobrenome)
                .endereco(endereco).complemento(complemento)
                .documento(documento)
                .email(email)
                .telefone(telefone)
                .cupomEntity(cupom)
                .build();

        if(idEstado != null){
            estado = entityManager.find(EstadoEntity.class, idEstado);
            compraEntity.setEstado(estado);
        }

        return compraEntity;
    }
}
