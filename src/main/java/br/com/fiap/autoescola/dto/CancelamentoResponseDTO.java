package br.com.fiap.autoescola.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelamentoResponseDTO {
    private Long instrucaoId;
    private boolean ativa;
    private String motivoCancelamento;
}
