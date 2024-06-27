package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.CompraDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.DetalhesCompraResponseDto;
import br.com.dsena7.journey_dev_eficiente.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    CompraService compraService;

    @PostMapping
    public ResponseEntity<String> compra(@RequestBody @Valid CompraDto compraDto) throws BusinessException {
        compraService.compra(compraDto);
        return ResponseEntity.ok().body("Compra efetuada com sucesso: " + compraDto);
    }

    @GetMapping(value = "{idCompra}")
    public ResponseEntity<DetalhesCompraResponseDto> detalhesCompra(@PathVariable Long idCompra) throws BusinessException {
//        compraService.buscaDetalhesCompra(idCompra);
        return ResponseEntity.ok().body(compraService.buscaDetalhesCompra(idCompra));
    }
}
