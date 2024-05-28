package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.PaisRequestDto;
import br.com.dsena7.journey_dev_eficiente.repository.PaisRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<String> inserePais(@Valid @RequestBody PaisRequestDto paisRequestDto) throws BusinessException {

        if (paisRepository.findByNomePais(paisRequestDto.getNomePais()) != null && paisRepository.findByNomePais(paisRequestDto.getNomePais()).getNomePais().equalsIgnoreCase(paisRequestDto.getNomePais())) {
            throw new BusinessException("País informado já existe, favor verificar: " + paisRequestDto.getNomePais());
        }
        paisRepository.save(paisRequestDto.toEntity(paisRequestDto));
        return ResponseEntity.ok().body(paisRequestDto.toString());
    }

}
