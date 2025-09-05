package br.com.fiap.autoescola.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrutorRequestDTO {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cnh;

    @NotBlank
    private String especialidade;

    @NotNull
    private EnderecoDTO endereco;
}
