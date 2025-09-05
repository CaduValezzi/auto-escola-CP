package br.com.fiap.autoescola.repository;

import br.com.fiap.autoescola.entity.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Page<Instrutor> findByAtivoTrue(Pageable pageable);
}
