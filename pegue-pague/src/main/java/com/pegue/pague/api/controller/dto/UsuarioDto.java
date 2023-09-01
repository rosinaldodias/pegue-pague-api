package com.pegue.pague.api.controller.dto;

import com.pegue.pague.api.entity.Usuario;

public class UsuarioDto {
	private Long id;
	private String login;
	
	public UsuarioDto() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioDto(Long id, String login) {
		this.id = id;
		this.login = login;
	}
	
	public UsuarioDto(Usuario user) {
		this.id = user.getCodigo();
		this.login = user.getLogin();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
	

}
