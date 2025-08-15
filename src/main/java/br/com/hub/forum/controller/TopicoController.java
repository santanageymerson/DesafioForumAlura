package br.com.hub.forum.controller;

import br.com.hub.forum.domain.topico.*;
import br.com.hub.forum.domain.usuario.Usuario;
import br.com.hub.forum.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController{

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public  ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico, UriComponentsBuilder uriBuilder){
        var estaNoBanco = repository.findByTitulo(dadosCadastroTopico.titulo());
        if(estaNoBanco.isPresent()){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT) // 409 Conflict
                    .body("Já existe um tópico com este título");
        }
        Usuario autor = usuarioRepository.findById(dadosCadastroTopico.usuarioId())
                        .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        var topico = new Topico(dadosCadastroTopico,autor);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size=10, sort = {"dataCriacao"}) Pageable paginacao){
        var page =repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dadosCadastroTopico){

        var topico = repository.getReferenceById(dadosCadastroTopico.id());
        topico.atualizarInformacoes(dadosCadastroTopico);

        return ResponseEntity.ok(new DadosListagemTopico (topico));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new dadosDetalhamentoTopico(topico));
    }

}
