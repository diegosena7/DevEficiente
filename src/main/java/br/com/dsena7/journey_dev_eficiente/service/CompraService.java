package br.com.dsena7.journey_dev_eficiente.service;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.CompraDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.CompraEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.CupomEntity;
import br.com.dsena7.journey_dev_eficiente.repository.CompraRepository;
import br.com.dsena7.journey_dev_eficiente.repository.CupomRepository;
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

    @Autowired
    private CupomRepository cupomRepository;
    public String compra(CompraDto compraDto) throws BusinessException {
        String codigo = "";
        if (compraDto.getCupom() != null){
            codigo = compraDto.getCupom().getCodigo();
        }

        CupomEntity cupomEntity = cupomRepository.findByCodigo(codigo);

        if(cupomEntity == null){
            throw new BusinessException("Código do cupom inserido não existe");
        }

        CompraEntity entity = compraDto.toEntity(entityManager, cupomEntity);
        repository.save(entity);
        return "Compra efetuada";
    }
}
