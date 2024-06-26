package br.com.dsena7.journey_dev_eficiente.service;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.CompraDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.CupomEntity;
import br.com.dsena7.journey_dev_eficiente.model.mappers.CarrinhoCompraMapper;
import br.com.dsena7.journey_dev_eficiente.repository.CarrinhoCompraRepository;
import br.com.dsena7.journey_dev_eficiente.repository.CompraRepository;
import br.com.dsena7.journey_dev_eficiente.repository.CupomRepository;
import com.mysql.cj.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompraService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CompraRepository repository;

    @Autowired
    private CupomRepository cupomRepository;

    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public String compra(CompraDto compraDto) throws BusinessException {

        carrinhoCompraRepository.save(CarrinhoCompraMapper.toEntity(compraDto.getPedido()));

        CupomEntity cupomEntity = null;

        if (!StringUtils.isNullOrEmpty(compraDto.getCodigoCupom())) {
            cupomEntity = cupomRepository.findByCodigo(compraDto.getCodigoCupom());
            if (cupomEntity == null) {
                throw new BusinessException("Código do cupom inserido não existe");
            }
            validaDataCupom(cupomEntity);
        }
        repository.save(compraDto.toEntity(entityManager, cupomEntity, compraDto));
        return "Compra efetuada";
    }

    private static void validaDataCupom(CupomEntity cupomEntity) throws BusinessException {
        if (cupomEntity.getDataDeValidade().isBefore(LocalDate.now())) {
            throw new BusinessException("Cupom com validade excedida.");
        }
    }
}
