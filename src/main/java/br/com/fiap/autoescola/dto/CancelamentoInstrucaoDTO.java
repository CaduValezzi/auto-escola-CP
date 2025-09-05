package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.entity.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelamentoInstrucaoDTO {

    @NotNull
    private MotivoCancelamento motivo;
}
