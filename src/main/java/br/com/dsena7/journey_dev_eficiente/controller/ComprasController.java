package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.model.dto.CompraDto;
import br.com.dsena7.journey_dev_eficiente.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String compra(@RequestBody @Valid CompraDto compraDto){
        compraService.compra(compraDto);
        return "Compra efetuada";
    }
}
