package br.com.fiap.autoescola.service;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.entity.*;
import br.com.fiap.autoescola.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class InstrucaoService {

    private final InstrucaoRepository instrucaoRepository;
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;

    public InstrucaoResponseDTO agendar(InstrucaoRequestDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        if (!aluno.isAtivo()) throw new RuntimeException("Aluno inativo não pode agendar instruções");

        LocalDateTime dataHora = dto.getDataHora();

        // Regras de horário
        if (dataHora.getMinute() != 0) {
            throw new RuntimeException("As instruções devem começar em hora cheia");
        }
        if (dataHora.getHour() < 6 || dataHora.getHour() >= 21) {
            throw new RuntimeException("Horário fora do funcionamento (06h às 21h)");
        }
        if (dataHora.isBefore(LocalDateTime.now().plusMinutes(30))) {
            throw new RuntimeException("Agendamento deve ter antecedência mínima de 30 minutos");
        }

        // Máximo 2 instruções por dia
        LocalDateTime inicioDia = dataHora.toLocalDate().atStartOfDay();
        LocalDateTime fimDia = inicioDia.plusDays(1).minusSeconds(1);
        List<Instrucao> instrucoesAluno = instrucaoRepository.findByAlunoIdAndDataHoraBetween(
                aluno.getId(), inicioDia, fimDia);
        if (instrucoesAluno.size() >= 2) {
            throw new RuntimeException("Aluno já possui 2 instruções neste dia");
        }

        // Instrutor
        Instrutor instrutor = null;
        if (dto.getInstrutorId() != null) {
            instrutor = instrutorRepository.findById(dto.getInstrutorId())
                    .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));
            if (!instrutor.isAtivo()) throw new RuntimeException("Instrutor inativo não pode ser agendado");

            if (instrucaoRepository.existsByInstrutorIdAndDataHora(instrutor.getId(), dataHora)) {
                throw new RuntimeException("Instrutor já possui instrução neste horário");
            }
        } else {
            // escolhe instrutor aleatório disponível
            List<Instrutor> instrutores = instrutorRepository.findAll()
                    .stream().filter(Instrutor::isAtivo).toList();
            if (instrutores.isEmpty()) throw new RuntimeException("Nenhum instrutor disponível");

            instrutor = instrutores.get(new Random().nextInt(instrutores.size()));
        }

        Instrucao instrucao = Instrucao.builder()
                .aluno(aluno)
                .instrutor(instrutor)
                .dataHora(dataHora)
                .ativa(true)
                .build();

        instrucaoRepository.save(instrucao);

        return new InstrucaoResponseDTO(
                instrucao.getId(),
                aluno.getNome(),
                instrutor.getNome(),
                instrucao.getDataHora(),
                instrucao.isAtiva()
        );
    }
}
