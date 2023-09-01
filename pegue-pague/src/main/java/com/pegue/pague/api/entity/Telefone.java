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

import com.pegue.pague.api.enums.Operadora;
import com.pegue.pague.api.enums.TipoTelefone;
@Entity
public class Telefone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_telefone;
	
	@Column(length = 40)
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private Operadora operadora;
	@Column(length = 4)
	private String ddd;
	@Column(length = 10)
	private String numero;
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(Long id_telefone, TipoTelefone tipoTelefone, Operadora operadora, String ddd, String numero,
			Pessoa pessoa) {
		this.id_telefone = id_telefone;
		this.tipoTelefone = tipoTelefone;
		this.operadora = operadora;
		this.ddd = ddd;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [id_telefone=" + id_telefone + ", tipoTelefone=" + tipoTelefone + ", operadora=" + operadora
				+ ", ddd=" + ddd + ", numero=" + numero + ", pessoa=" + pessoa+ "]";
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id_telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(id_telefone, other.id_telefone);
	}
	
	
}
