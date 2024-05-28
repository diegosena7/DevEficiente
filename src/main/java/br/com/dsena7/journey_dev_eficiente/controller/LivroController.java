package br.com.dsena7.journey_dev_eficiente.controller;

import br.com.dsena7.journey_dev_eficiente.exceptions.BusinessException;
import br.com.dsena7.journey_dev_eficiente.model.dto.LivroDto;
import br.com.dsena7.journey_dev_eficiente.model.dto.LivroResponseDto;
import br.com.dsena7.journey_dev_eficiente.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public String criarLivro(@RequestBody @Valid LivroDto livroDto) throws BusinessException {
        livroService.criarLivro(livroDto);
        return livroDto.toString();
    }

    @GetMapping
    public List<LivroResponseDto> buscarLivros(){
        return livroService.buscarLivros();
    }

    @GetMapping(value = "{idLivro}")
    public ResponseEntity<LivroResponseDto> buscarPaginaDeUmLivroo(@PathVariable Long idLivro) throws BusinessException {
        return livroService.buscarPaginaDeUmLivro(idLivro);
    }
}
