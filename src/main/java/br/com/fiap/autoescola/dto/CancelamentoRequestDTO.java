package br.com.fiap.autoescola.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelamentoRequestDTO {
    @NotBlank
    private String motivo; // aluno desistiu, instrutor cancelou, outros
}

