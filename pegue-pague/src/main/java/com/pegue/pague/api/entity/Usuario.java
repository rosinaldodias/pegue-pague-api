package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_usuario;
	@Column(length
			= 100)
	private String login;
	@Column(length = 100)
	private String senha;
	private Boolean ativo; 
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataCadastro;
	@OneToOne
	private Pessoa pessoa;
	
	public Usuario() {
	}
	
	public Usuario(Long codigo, String login, String senha, Boolean ativo, LocalDate dataCadastro, Pessoa pessoa) {
		this.id_usuario = codigo;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.pessoa = pessoa;
	}
	@Override
	public String toString() {
		return "Usuario [codigo=" + id_usuario + ", login=" + login + ", senha=" + senha + ", ativo=" + ativo
				+ ", dataCadastro=" + dataCadastro + ", pessoa=" + pessoa + "]";
	}

	public Long getCodigo() {
		return id_usuario;
	}
	public void setCodigo(Long codigo) {
		this.id_usuario = codigo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id_usuario, other.id_usuario);
	}


}
