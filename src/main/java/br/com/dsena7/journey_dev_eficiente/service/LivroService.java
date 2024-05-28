package br.com.dsena7.journey_dev_eficiente.service;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.AutorResponseDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.LivroDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.LivroResponseDto;
import br.com.dsena7.journey_dev_eficiente.model.entity.AutorEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.CategoriaEntity;
import br.com.dsena7.journey_dev_eficiente.model.entity.LivroEntity;
import br.com.dsena7.journey_dev_eficiente.repository.AutorRepository;
import br.com.dsena7.journey_dev_eficiente.repository.CategoriaRepository;
import br.com.dsena7.journey_dev_eficiente.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;

    public LivroDto criarLivro(LivroDto dto) throws BusinessException {

        CategoriaEntity categoriaEntity = categoriaRepository.findById(dto.getIdCategoria()).orElseThrow(()->
                new BusinessException("Id da categoria informado não existe: " + dto.getIdCategoria()));

        AutorEntity autorEntity = autorRepository.findById(dto.getIdAutor()).orElseThrow(() ->
                new BusinessException("Id do autor informado não existe: " + dto.getIdAutor()));

        if (livroRepository.findByTitulo(dto.getTitulo()) != null && livroRepository.findByTitulo(dto.getTitulo()).getTitulo().equalsIgnoreCase(dto.getTitulo())) {
            throw new BusinessException("O título informado já existe: " + dto.getTitulo());
        }

        livroRepository.save(dto.toEntity(dto, autorEntity, categoriaEntity));
        return dto;
    }

    public List<LivroResponseDto> buscarLivros() {
        LivroResponseDto livroResponseDto = new LivroResponseDto();
        List<LivroEntity> listLivros = livroRepository.findAll();
        if (!listLivros.isEmpty()){
        return livroResponseDto.entityToDtoList(listLivros);
        }
        return new ArrayList<>();
    }

    public ResponseEntity<LivroResponseDto> buscarPaginaDeUmLivro(Long idLivro) throws BusinessException {
        Optional<LivroEntity> livroEntity = livroRepository.findById(idLivro);
        if (livroEntity.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        AutorResponseDto autorRequestDto = new AutorResponseDto();
        return ResponseEntity.ok(LivroResponseDto.builder()
                        .autorEntity(autorRequestDto.toEntityResponse(livroEntity.get().getAutorEntity()))
                .isbn(livroEntity.get().getIsbn())
                .numeroDePaginas(livroEntity.get().getNumeroDePaginas())
                .titulo(livroEntity.get().getTitulo())
                .resumo(livroEntity.get().getResumo())
                .preco(livroEntity.get().getPreco())
                .dataPublicacao(livroEntity.get().getDataPublicacao())
                .sumario(livroEntity.get().getSumario())
                .build());
    }
}
