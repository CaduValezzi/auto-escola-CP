package br.com.fiap.autoescola.entity;

import br.com.fiap.autoescola.vo.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Embedded
    private Endereco endereco;

    @Column(nullable = false)
    private boolean ativo = true;
}
