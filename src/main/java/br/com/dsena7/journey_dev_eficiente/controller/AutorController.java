package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.AutorRequestDto;
import br.com.dsena7.journey_dev_eficiente.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping
    public ResponseEntity<String> insereAutor(@Valid @RequestBody AutorRequestDto autor) throws BusinessException {

        service.insereAutor(autor);
        return ResponseEntity.ok().body("Criado novo autor com sucesso: " + autor.toString());
    }
}
