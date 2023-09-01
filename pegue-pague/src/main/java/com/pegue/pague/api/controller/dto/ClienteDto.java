package com.pegue.pague.api.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pegue.pague.api.entity.Pessoa;
import com.pegue.pague.api.enums.TipoPessoa;

public class ClienteDto implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPessoa;
	@NotBlank
	private String nome;
	private String cpfCnpj;
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;	
	@NotBlank
	@Email
	private String email;
	private Double limiteCredido;
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private Date dataCadastro;
	private String informacoesAdicionais;
	private List<EnderecoDto> enderecos; 
	private List<TelefoneDto> telefones;
	private Boolean ativo;
	
	public ClienteDto() {
		// TODO Auto-generated constructor stub
	}

	public ClienteDto(Long idPessoa, @NotBlank String nome, String cpfCnpj, TipoPessoa tipoPessoa,
			@NotBlank @Email String email, Double limiteCredido, Date dataCadastro, String informacoesAdicionais,
			Boolean ativo) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.tipoPessoa = tipoPessoa;
		this.email = email;
		this.limiteCredido = limiteCredido;
		this.dataCadastro = dataCadastro;
		this.informacoesAdicionais = informacoesAdicionais;
		this.ativo = ativo;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}

    
	public List<TelefoneDto> getTelefones() {
		if (this.telefones == null) {
			this.telefones = new ArrayList<>();
		}
		return telefones;

	}

	public void setTelefones(List<TelefoneDto> telefones) {
		this.telefones = telefones;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	

}