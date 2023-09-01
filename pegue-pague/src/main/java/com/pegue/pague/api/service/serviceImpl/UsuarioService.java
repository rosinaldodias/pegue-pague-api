package com.pegue.pague.api.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.pegue.pague.api.entity.Usuario;

public interface UsuarioService {
	
	List<Usuario> listUser();
	Optional<Usuario> findByCodigo(long codigo);
	Usuario save(Usuario usuario);
	Usuario edit(Long codigo);

}
