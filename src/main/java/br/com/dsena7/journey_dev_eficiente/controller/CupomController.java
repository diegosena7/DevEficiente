package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.CupomRequestDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.CupomEntity;
import br.com.dsena7.journey_dev_eficiente.repository.CompraRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupons")
public class CupomController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    CompraRepository compraRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insereCupom(@Valid @RequestBody CupomRequestDto cupomRequestDto) throws BusinessException {

        CupomEntity cupomEntity = CupomEntity.builder()
                .codigo(cupomRequestDto.getCodigo())
                .dataDeValidade(cupomRequestDto.getDataDeValidade())
                .percentual(cupomRequestDto.getPercentual())
                .build();

//        if (cupomService.verificaCupomExistente(cupomEntity)){
//            throw new BusinessException("Cupom já existe, informe outro cupom.");
//        }

        entityManager.persist(cupomEntity);
        return ResponseEntity.ok().body("Cupom inserido com sucesso: " + cupomRequestDto);
    }
}
