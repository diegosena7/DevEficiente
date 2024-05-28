package br.com.dsena7.journey_dev_eficiente.service;

import br.com.dsena7.journey_dev_eficiente.model.dto.CompraDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import br.com.dsena7.journey_dev_eficiente.repository.CompraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CompraRepository repository;
    public String compra(CompraDto compraDto){
        CompraEntity entity = compraDto.toEntity(entityManager);
        repository.save(entity);
        return "Compra efetuada";
    }
}
