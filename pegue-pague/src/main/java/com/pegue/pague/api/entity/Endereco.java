package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pegue.pague.api.enums.TipoEndereco;
@Entity
public class Endereco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_endereco;
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	@Column(length = 100)
	private String logradouro;
	@Column(length = 100)
	private String complemento;
	@Column(length = 20)
	private String numero;
	@Column(length = 100)
	private String bairro;
	@Column(length = 100)
	private String cidade;
	@Column(length = 8)
	private String cep;
	@Column(length = 2)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name ="pessoa")
	private Pessoa pessoa;
	
	public Endereco() {
	}

	public Endereco(Long codigo, TipoEndereco tipoEndereco, String logradouro, String complemento, String numero,
			String bairro, String cidade, String cep, String estado, Pessoa pessoa) {
		super();
		this.id_endereco = codigo;
		this.tipoEndereco = tipoEndereco;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.pessoa = pessoa;
	}

	

	@Override
	public String toString() {
		return "Endereco [id_endereco=" + id_endereco + ", tipoEndereco=" + tipoEndereco + ", logradouro=" + logradouro
				+ ", complemento=" + complemento + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", cep=" + cep + ", estado=" + estado + ", pessoa=" + pessoa + "]";
	}

	public Long getCodigo() {
		return id_endereco;
	}

	public void setCodigo(Long codigo) {
		this.id_endereco = codigo;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
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


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id_endereco, other.id_endereco);
	}
	
	

}
