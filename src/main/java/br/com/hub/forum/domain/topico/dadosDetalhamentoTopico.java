package br.com.hub.forum.domain.topico;

import br.com.hub.forum.domain.resposta.Resposta;

import java.time.format.DateTimeFormatter;
import java.util.List;

public record dadosDetalhamentoTopico(Long id,
                                      String titulo,
                                      String mesagem,
                                      String dataCriacao,
                                      String nomeAutor,
                                      Status status,
                                      List<Resposta> respostas) {
    public dadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                topico.getAutor().getNome(),topico.getStatus(),topico.getRespostas());
    }
}
