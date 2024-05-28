package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.ClienteEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.EstadoEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import br.com.dsena7.journey_dev_eficiente.validators.CepValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteRequestDto {

    @Email @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CPF
    private String documento; //(cpf/cnpj)@NotBlank

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private PaisRequestDto pais;

    @NotNull
    private EstadoRequestDto estado; //(caso aquele pais tenha estado)

    @Pattern(regexp = "\\d{10,14}", message = "O telefone deve ter entre 10 e 14 dígitos.")
    private String telefone;

    @NotBlank
    @CepValid
    private String cep;

    public ClienteEntity toEntity(ClienteRequestDto clienteRequestDto, PaisEntity paisEntity, EstadoEntity estadoEntity) {
        return ClienteEntity.builder()
                .cep(clienteRequestDto.getCep())
                .cidade(clienteRequestDto.getCidade())
                .complemento(clienteRequestDto.getComplemento())
                .documento(clienteRequestDto.getDocumento())
                .email(clienteRequestDto.getEmail())
                .endereco(clienteRequestDto.getEndereco())
                .estado(estadoEntity)
                .pais(paisEntity)
                .sobrenome(clienteRequestDto.getSobrenome())
                .nome(clienteRequestDto.getNome())
                .telefone(clienteRequestDto.getTelefone())
                .build();
    }
}
