package br.com.gerenciador.exercicio.controller;

import br.com.gerenciador.exercicio.domain.dto.UsuarioRequest;
import br.com.gerenciador.exercicio.domain.model.Usuario;
import br.com.gerenciador.exercicio.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioRequest request, UriComponentsBuilder uriBuilder){
        log.info("chamando save do usario controller: " + request);
        Usuario usuario = service.save(request);
        URI uri = uriBuilder.path("api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
}
