package br.com.dsena7.journey_dev_eficiente.model.mappers;

import br.com.dsena7.journey_dev_eficiente.model.dto.CarrinhoCompraDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.DetalhesCompraResponseDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.ItensCarrinhoDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.CarrinhoCompraEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.ItensCarrinhoEntity;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CarrinhoCompraMapper {

    public static CarrinhoCompraEntity toEntity(CarrinhoCompraDto dto) {
        return CarrinhoCompraEntity.builder()
                .total(dto.getTotal())
                .itens(dto.getItens().stream()
                        .map(CarrinhoCompraMapper::toEntity)
                        .collect(toList()))
                .build();
    }

    private static ItensCarrinhoEntity toEntity(ItensCarrinhoDto dto) {
        return ItensCarrinhoEntity.builder()
                .idLivro(dto.getIdLivro())
                .quantidade(dto.getQuantidade())
                .build();
    }

    // Converte CarrinhoCompraEntity em CarrinhoCompraDto
    public static CarrinhoCompraDto toDto(CarrinhoCompraEntity entity) {
        CarrinhoCompraDto.CarrinhoCompraDtoBuilder builder = CarrinhoCompraDto.builder();
        builder.total(entity.getTotal());
        builder.itens(entity.getItens().stream()
                .map(CarrinhoCompraMapper::toDto)
                .collect(toList()));
        return builder
                .build();
    }

    // Converte ItensCarrinhoEntity em ItensCarrinhoDto
    private static ItensCarrinhoDto toDto(ItensCarrinhoEntity entity) {
        return ItensCarrinhoDto.builder()
                .quantidade(entity.getQuantidade())
                .idLivro(entity.getIdLivro())
                .build();
    }

    public static DetalhesCompraResponseDto detalhesCompraResponseDtotoDto(CompraEntity compraEntity, CarrinhoCompraDto carrinhoCompraDto){
        return DetalhesCompraResponseDto.builder()
                .email(compraEntity.getEmail())
                .nome(compraEntity.getNome())
                .sobrenome(compraEntity.getSobrenome())
                .endereco(compraEntity.getEndereco())
                .complemento(compraEntity.getComplemento())
                .cep(compraEntity.getCep())
                .cidade(compraEntity.getCidade())
                .telefone(compraEntity.getTelefone())
                .pedido(carrinhoCompraDto)
                .codigoCupom(compraEntity.getCupomEntity().getCodigo())
                .build();
    }
}
