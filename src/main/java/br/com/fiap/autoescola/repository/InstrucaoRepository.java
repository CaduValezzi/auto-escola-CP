package br.com.fiap.autoescola.repository;

import br.com.fiap.autoescola.entity.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {

    List<Instrucao> findByAlunoIdAndDataHoraBetween(Long alunoId, LocalDateTime inicio, LocalDateTime fim);

    boolean existsByInstrutorIdAndDataHora(Long instrutorId, LocalDateTime dataHora);
}
