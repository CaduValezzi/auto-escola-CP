package br.com.fiap.autoescola.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstrutorResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cnh;
    private String especialidade;
}

