package br.com.fiap.autoescola.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrucaoResponseDTO {
    private Long id;
    private String alunoNome;
    private String instrutorNome;
    private LocalDateTime dataHora;
    private boolean ativa;
}


