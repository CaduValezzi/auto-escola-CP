package br.com.fiap.autoescola.entity;

import br.com.fiap.autoescola.vo.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instrutores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, length = 20, unique = true)
    private String cnh;

    @Column(nullable = false, length = 50)
    private String especialidade; // motos, carros, vans, caminhões

    @Embedded
    private Endereco endereco;

    @Column(nullable = false)
    private boolean ativo = true;
}