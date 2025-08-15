package br.com.hub.forum.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String mensagem,
        String titulo) {
}
