package br.com.hub.forum.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Optional<Topico> findByTitulo(@NotBlank String titulo);
}
