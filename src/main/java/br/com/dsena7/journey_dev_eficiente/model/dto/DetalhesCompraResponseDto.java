package br.com.dsena7.journey_dev_eficiente.model.dto;

import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalhesCompraResponseDto {

    private String email;

    private String nome;

    private String sobrenome;

    private String endereco;

    private String complemento;

    private String cep;

    private String cidade;

    private String telefone;

    private CarrinhoCompraDto pedido;

    private String codigoCupom;


}
