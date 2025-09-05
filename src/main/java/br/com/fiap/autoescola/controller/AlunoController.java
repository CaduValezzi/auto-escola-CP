package br.com.fiap.autoescola.controller;

import br.com.fiap.autoescola.dto.AlunoRequestDTO;
import br.com.fiap.autoescola.dto.AlunoResponseDTO;
import br.com.fiap.autoescola.dto.AlunoUpdateDTO;
import br.com.fiap.autoescola.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public AlunoResponseDTO criar(@RequestBody @Valid AlunoRequestDTO dto) {
        return alunoService.salvar(dto);
    }

    @GetMapping
    public Page<AlunoResponseDTO> listar(Pageable pageable) {
        return alunoService.listar(pageable);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid AlunoUpdateDTO dto) {
        return alunoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        alunoService.excluir(id);
    }

}