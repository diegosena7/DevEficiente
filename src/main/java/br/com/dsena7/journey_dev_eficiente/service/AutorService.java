package br.com.dsena7.journey_dev_eficiente.service;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.AutorRequestDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import br.com.dsena7.journey_dev_eficiente.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository repository;

    public String insereAutor(AutorRequestDto autorRequestDto) throws BusinessException {
        List<AutorEntity> entity = repository.findByEmail(autorRequestDto.getEmail());
        if (!entity.isEmpty()) {
            throw new BusinessException("Autor com e-mail informado já existe, favor verificar: " + autorRequestDto.getEmail());
        }
        repository.save(autorRequestDto.toEntity(autorRequestDto));
        return "Autor: " + autorRequestDto;
    }
}
