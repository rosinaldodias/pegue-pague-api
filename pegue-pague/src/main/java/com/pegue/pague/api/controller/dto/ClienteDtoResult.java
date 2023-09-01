package com.pegue.pague.api.controller.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pegue.pague.api.entity.Pessoa;

public class ClienteDtoResult {
	private Long id_cliente;
	private String nome;
	private String email;
	private String cpfCnpj;
	private Double limiteCredido;
	private Date dataCadastro;
	private String informacoesAdicionais;
	private Boolean ativo;

	
	public ClienteDtoResult() {
		// TODO Auto-generated constructor stub
	}


	public ClienteDtoResult(Long id_cliente, String nome, String email, String cpfCnpj, Double limiteCredido,
			Date dataCadastro, String informacoesAdicionais, Boolean ativo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.limiteCredido = limiteCredido;
		this.dataCadastro = dataCadastro;
		this.informacoesAdicionais = informacoesAdicionais;
		this.ativo = ativo;
	}


	public Long getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpfCnpj() {
		return cpfCnpj;
	}


	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}


	public Double getLimiteCredido() {
		return limiteCredido;
	}


	public void setLimiteCredido(Double limiteCredido) {
		this.limiteCredido = limiteCredido;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}


	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	
	
	

}
