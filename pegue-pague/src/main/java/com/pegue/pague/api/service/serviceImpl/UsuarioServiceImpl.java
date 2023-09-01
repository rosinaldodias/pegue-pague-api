package com.pegue.pague.api.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pegue.pague.api.Repository.UsuarioRepository;
import com.pegue.pague.api.entity.Usuario;

public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public List<Usuario> listUser() {
		return repo.findAll();
	}

	@Override
	public Optional<Usuario> findByCodigo(long codigo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario edit(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
