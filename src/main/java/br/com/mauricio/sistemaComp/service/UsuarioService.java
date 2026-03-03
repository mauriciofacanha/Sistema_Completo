package br.com.mauricio.sistemaComp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauricio.sistemaComp.dto.UsuarioDTO;
import br.com.mauricio.sistemaComp.entity.UsuarioEntity;
import br.com.mauricio.sistemaComp.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir (UsuarioDTO userDto) {
        UsuarioEntity userEntity = new UsuarioEntity(userDto);
        usuarioRepository.save(userEntity);
    }

    public UsuarioDTO alterar (UsuarioDTO userDto){
        UsuarioEntity userEntity = new UsuarioEntity(userDto);
        return new UsuarioDTO(usuarioRepository.save(userEntity));
    }

    public void excluir (Long id){
        UsuarioEntity userEntity = usuarioRepository.findById(id).get();
        usuarioRepository.delete(userEntity);
    }

    public UsuarioDTO buscarPorId(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}