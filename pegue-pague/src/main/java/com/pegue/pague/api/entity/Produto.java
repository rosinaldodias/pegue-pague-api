package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pegue.pague.api.enums.Unidade;

@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_produto;
	@Column(length = 100)
	private String nome;
	@Enumerated(EnumType.STRING)
	private Unidade unidade;
	private Integer estoque;
	private Double pis;
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private Date dataCadastro;
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	private Boolean ativo;
	
	public Produto() {
	}

	public Produto(Long codigo, String nome, Unidade unidade, Integer estoque, Double pis, Date dataCadastro,
			Categoria categoria, Boolean ativo) {
		
		this.id_produto = codigo;
		this.nome = nome;
		this.unidade = unidade;
		this.estoque = estoque;
		this.pis = pis;
		this.dataCadastro = dataCadastro;
		this.categoria = categoria;
		this.ativo = ativo;
	}

	public Long getCodigo() {
		return id_produto;
	}

	public void setCodigo(Long codigo) {
		this.id_produto = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getPis() {
		return pis;
	}

	public void setPis(Double pis) {
		this.pis = pis;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + id_produto + ", nome=" + nome + ", unidade=" + unidade + ", estoque=" + estoque
				+ ", pis=" + pis + ", dataCadastro=" + dataCadastro + ", categoria=" + categoria + ", ativo=" + ativo
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id_produto, other.id_produto);
	}
	
	
}
