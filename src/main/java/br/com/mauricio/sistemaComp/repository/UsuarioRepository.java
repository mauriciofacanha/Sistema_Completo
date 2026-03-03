package br.com.mauricio.sistemaComp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mauricio.sistemaComp.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    
}
