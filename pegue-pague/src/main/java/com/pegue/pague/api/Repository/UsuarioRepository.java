package com.pegue.pague.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegue.pague.api.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

}
