package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_cliente;
	private Double limiteCredido;
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private Date dataCadastro;
	@Column(length = 500)
	private String informacoesAdicionais;
	@OneToOne
	@JoinColumn(name = "id_pessoa" )
	private Pessoa pessoa;
	private Boolean ativo;
	
	public Cliente() {
	}

	public Cliente(Long id_cliente, Double limiteCredido, Date dataCadastro, String informacoesAdicionais,
			Pessoa pessoa, Boolean ativo) {
		super();
		this.id_cliente = id_cliente;
		this.limiteCredido = limiteCredido;
		this.dataCadastro = dataCadastro;
		this.informacoesAdicionais = informacoesAdicionais;
		this.pessoa = pessoa;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", limiteCredido=" + limiteCredido + ", dataCadastro="
				+ dataCadastro + ", informacoesAdicionais=" + informacoesAdicionais + ", pessoa=" + pessoa + ", ativo="
				+ ativo + "]";
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id_cliente, other.id_cliente);
	}

	
	
	

}
