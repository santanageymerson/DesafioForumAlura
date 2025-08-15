package br.com.hub.forum.domain.topico;

import java.time.format.DateTimeFormatter;

public record DadosListagemTopico(Long id, String titulo, String mensagem, String dataCriacao) {

    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }
}
