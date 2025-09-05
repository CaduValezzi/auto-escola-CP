package br.com.fiap.autoescola.controller;

import br.com.fiap.autoescola.dto.InstrucaoRequestDTO;
import br.com.fiap.autoescola.dto.InstrucaoResponseDTO;
import br.com.fiap.autoescola.service.InstrucaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrucoes")
@RequiredArgsConstructor
public class InstrucaoController {

    private final InstrucaoService instrucaoService;

    @PostMapping
    public InstrucaoResponseDTO agendar(@RequestBody @Valid InstrucaoRequestDTO dto) {
        return instrucaoService.agendar(dto);
    }
}

