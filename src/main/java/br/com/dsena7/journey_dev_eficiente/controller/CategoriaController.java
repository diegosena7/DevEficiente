package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.CategoriaDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.CategoriaEntity;
import br.com.dsena7.journey_dev_eficiente.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository repository;

    @PostMapping
    public ResponseEntity<String> insereCategoria(@Valid @RequestBody CategoriaDto categoriaDto) throws BusinessException {
        Optional<CategoriaEntity> byNome = repository.findByNome(categoriaDto.getNome());
        if(byNome.isPresent()){
            throw new BusinessException("Categoria informada já existe, favor verificar: " + categoriaDto.getNome());
        }
        repository.save(categoriaDto.toEntity(categoriaDto));
        return ResponseEntity.ok().body("Criado nova categoria com sucesso: " + categoriaDto.getNome());
    }
}
