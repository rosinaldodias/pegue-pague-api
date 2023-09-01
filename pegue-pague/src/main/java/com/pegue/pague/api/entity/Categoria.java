package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Categoria implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_cotegoria;
	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100)
	@NotBlank
	private String nome;
	private Boolean ativo;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long id, String nome, Boolean ativo) {
		this.id_cotegoria = id;
		this.nome = nome;
		this.ativo = ativo;
	}

	public Long getId() {
		return id_cotegoria;
	}

	public void setId(Long id) {
		this.id_cotegoria = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id_cotegoria + ", nome=" + nome + ", ativo=" + ativo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_cotegoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id_cotegoria, other.id_cotegoria);
	}
	
	
}
