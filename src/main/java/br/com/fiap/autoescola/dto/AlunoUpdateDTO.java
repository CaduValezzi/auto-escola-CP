package br.com.fiap.autoescola.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoUpdateDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotNull
    private EnderecoDTO endereco;
}