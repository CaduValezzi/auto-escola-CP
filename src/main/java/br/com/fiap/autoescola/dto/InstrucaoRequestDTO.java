package br.com.fiap.autoescola.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrucaoRequestDTO {

    @NotNull
    private Long alunoId;

    private Long instrutorId; // opcional

    @NotNull
    @Future
    private LocalDateTime dataHora;
}
