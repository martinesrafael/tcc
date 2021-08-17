package br.com.gerenciador.exercicio.controller;

import br.com.gerenciador.exercicio.domain.dto.UsuarioRequest;
import br.com.gerenciador.exercicio.domain.model.Usuario;
import br.com.gerenciador.exercicio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioRequest request, UriComponentsBuilder uriBuilder){
        Usuario usuario = service.save(request);
        URI uri = uriBuilder.path("api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
}
