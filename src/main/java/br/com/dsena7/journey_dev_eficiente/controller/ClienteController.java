package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.ClienteRequestDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.EstadoEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.PaisEntity;
import br.com.dsena7.journey_dev_eficiente.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<String> inserePais(@Valid @RequestBody ClienteRequestDto clienteRequestDto) throws BusinessException {

        PaisEntity paisEntity = paisRepository.findById(clienteRequestDto.getEstado().getIdPais()).orElseThrow(()->
                new BusinessException("Id do país informado não existe: " + clienteRequestDto.getPais().getId()));

        EstadoEntity estadoEntity = estadoRepository.findByNomeEstado(clienteRequestDto.getEstado().getNomeEstado());
        if(estadoEntity == null){
            throw new BusinessException("Estado informado não existe: " + clienteRequestDto.getEstado().getNomeEstado());
        }

        clienteRepository.save(clienteRequestDto.toEntity(clienteRequestDto, paisEntity, estadoEntity));
        return ResponseEntity.ok().body("Criado novo cliente com sucesso: " + clienteRequestDto);
    }

}
