package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.EstadoRequestDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import br.com.dsena7.journey_dev_eficiente.repository.EstadoRepository;
import br.com.dsena7.journey_dev_eficiente.repository.PaisRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<String> inserePais(@Valid @RequestBody EstadoRequestDto estadoRequestDto) throws BusinessException {

        if (estadoRepository.findByNomeEstado(estadoRequestDto.getNomeEstado())!= null &&
                estadoRepository.findByNomeEstado(estadoRequestDto.getNomeEstado()).getNomeEstado().equalsIgnoreCase(estadoRequestDto.getNomeEstado())) {
            throw new BusinessException("Estado informado já existe, favor verificar: " + estadoRequestDto.getNomeEstado());
        }

        PaisEntity paisEntity = paisRepository.findById(estadoRequestDto.getIdPais()).orElseThrow(()->
                new BusinessException("Id do país informado não existe: " + estadoRequestDto.getIdPais()));

        estadoRepository.save(estadoRequestDto.toEntity(estadoRequestDto, paisEntity));
        return ResponseEntity.ok().body("Criado novo estado com sucesso: " + estadoRequestDto.getNomeEstado());
    }
}
