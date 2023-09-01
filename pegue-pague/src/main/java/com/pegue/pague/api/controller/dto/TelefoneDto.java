package com.pegue.pague.api.controller.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.pegue.pague.api.enums.Operadora;
import com.pegue.pague.api.enums.TipoTelefone;

public class TelefoneDto {

	private Long id_telefone;
	@Enumerated(EnumType.STRING)
	@NotBlank
	private TipoTelefone tipoTelefone;
	@Enumerated(EnumType.STRING)
	@NotBlank
	private Operadora operadora;
	@NotBlank
	private String ddd;
	@NotBlank
	private String numero;
	private Long id_pessoa;
	
	public TelefoneDto() {
		// TODO Auto-generated constructor stub
	}

	public TelefoneDto(Long id_telefone, @NotBlank TipoTelefone tipoTelefone, @NotBlank Operadora operadora,
			@NotBlank String ddd, @NotBlank String numero, Long id_pessoa) {
		super();
		this.id_telefone = id_telefone;
		this.tipoTelefone = tipoTelefone;
		this.operadora = operadora;
		this.ddd = ddd;
		this.numero = numero;
		this.id_pessoa = id_pessoa;
	}

	public Long getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(Long id_telefone) {
		this.id_telefone = id_telefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
	
	
	
	
	

}
