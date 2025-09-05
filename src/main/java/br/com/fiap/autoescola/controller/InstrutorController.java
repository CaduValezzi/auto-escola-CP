package br.com.fiap.autoescola.controller;

import br.com.fiap.autoescola.dto.InstrutorRequestDTO;
import br.com.fiap.autoescola.dto.InstrutorResponseDTO;
import br.com.fiap.autoescola.dto.InstrutorUpdateDTO;
import br.com.fiap.autoescola.service.InstrutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutores")
@RequiredArgsConstructor
public class InstrutorController {

    private final InstrutorService instrutorService;

    @PostMapping
    public InstrutorResponseDTO criar(@RequestBody @Valid InstrutorRequestDTO dto) {
        return instrutorService.salvar(dto);
    }

    @GetMapping
    public Page<InstrutorResponseDTO> listar(Pageable pageable) {
        return instrutorService.listar(pageable);
    }

    @PutMapping("/{id}")
    public InstrutorResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid InstrutorUpdateDTO dto) {
        return instrutorService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        instrutorService.excluir(id);
    }

}
