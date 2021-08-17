package br.com.gerenciador.exercicio.service;

import br.com.gerenciador.exercicio.domain.dto.UsuarioRequest;
import br.com.gerenciador.exercicio.domain.model.Usuario;
import br.com.gerenciador.exercicio.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;


    public Usuario save(UsuarioRequest request){
        Usuario usuario = mapper.map(request, Usuario.class);
        return repository.save(usuario);
    }
}
