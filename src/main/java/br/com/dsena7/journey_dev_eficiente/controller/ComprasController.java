package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.CompraDto;
import br.com.dsena7.journey_dev_eficiente.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
