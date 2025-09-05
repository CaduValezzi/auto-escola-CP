package br.com.fiap.autoescola.service;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.entity.Instrutor;
import br.com.fiap.autoescola.repository.InstrutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrutorService {

    private final InstrutorRepository instrutorRepository;

    public InstrutorResponseDTO salvar(InstrutorRequestDTO dto) {
        Instrutor instrutor = Instrutor.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .cnh(dto.getCnh())
                .especialidade(dto.getEspecialidade())
                .endereco(dto.getEndereco().toEntity())
                .ativo(true)
                .build();

        instrutor = instrutorRepository.save(instrutor);

        return new InstrutorResponseDTO(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getCnh(),
                instrutor.getEspecialidade()
        );
    }

    public Page<InstrutorResponseDTO> listar(Pageable pageable) {
        return instrutorRepository.findByAtivoTrue(pageable)
                .map(instrutor -> new InstrutorResponseDTO(
                        instrutor.getId(),
                        instrutor.getNome(),
                        instrutor.getEmail(),
                        instrutor.getCnh(),
                        instrutor.getEspecialidade()
                ));
    }

    public InstrutorResponseDTO atualizar(Long id, InstrutorUpdateDTO dto) {
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));

        if (!instrutor.isAtivo()) {
            throw new RuntimeException("Instrutor inativo não pode ser atualizado");
        }

        instrutor.setNome(dto.getNome());
        instrutor.setTelefone(dto.getTelefone());
        instrutor.setEndereco(dto.getEndereco().toEntity());

        instrutorRepository.save(instrutor);

        return new InstrutorResponseDTO(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getCnh(),
                instrutor.getEspecialidade()
        );
    }

    public void excluir(Long id) {
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));
        instrutor.setAtivo(false);
        instrutorRepository.save(instrutor);
    }

}
