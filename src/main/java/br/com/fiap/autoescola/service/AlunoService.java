package br.com.fiap.autoescola.service;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.entity.Aluno;
import br.com.fiap.autoescola.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoResponseDTO salvar(AlunoRequestDTO dto) {
        Aluno aluno = Aluno.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco().toEntity()) // precisa mapear
                .ativo(true)
                .build();

        aluno = alunoRepository.save(aluno);

        return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

    public Page<AlunoResponseDTO> listar(Pageable pageable) {
        return alunoRepository.findByAtivoTrue(pageable)
                .map(aluno -> new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf()));
    }

    public AlunoResponseDTO atualizar(Long id, AlunoUpdateDTO dto) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (!aluno.isAtivo()) {
            throw new RuntimeException("Aluno inativo não pode ser atualizado");
        }

        aluno.setNome(dto.getNome());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEndereco(dto.getEndereco().toEntity());

        alunoRepository.save(aluno);

        return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

    public void excluir(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setAtivo(false);
        alunoRepository.save(aluno);
    }


}