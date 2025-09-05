package br.com.fiap.autoescola.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
}