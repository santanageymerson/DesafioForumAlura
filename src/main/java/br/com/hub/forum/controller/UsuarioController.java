package br.com.hub.forum.controller;

import br.com.hub.forum.domain.usuario.DadosUsuario;
import br.com.hub.forum.domain.usuario.Usuario;
import br.com.hub.forum.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosUsuario dadosUsuario, UriComponentsBuilder uriBuilder){
        var usuario =new Usuario(dadosUsuario);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }
}
