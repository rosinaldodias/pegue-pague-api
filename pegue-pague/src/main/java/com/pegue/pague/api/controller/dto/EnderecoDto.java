package com.pegue.pague.api.controller.dto;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.pegue.pague.api.enums.TipoEndereco;

public class EnderecoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	@NotBlank
	private TipoEndereco tipoEndereco;
	@NotBlank
	private String lagradouro;
	private String complemento;
	private String numero;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	private String cep;
	@NotBlank
	private String estado;
	
	public EnderecoDto() {
		// TODO Auto-generated constructor stub
	}

	public EnderecoDto(@NotBlank TipoEndereco tipoEndereco, @NotBlank String lagradouro, String complemento,
			String numero, @NotBlank String bairro, @NotBlank String cidade, String cep, @NotBlank String estado) {
		super();
		this.tipoEndereco = tipoEndereco;
		this.lagradouro = lagradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getLagradouro() {
		return lagradouro;
	}

	public void setLagradouro(String lagradouro) {
		this.lagradouro = lagradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
