package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ItensPedido  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_itens_pedido;
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produtos;
	private Integer quantidade;
	private Double valor;
	private Double desconto;
	private Double acrescimo;
	
	public ItensPedido() {
	}

	public ItensPedido(Long id_itens_pedido, Pedido pedido, Produto produtos, Integer quantidade, Double valor,
			Double desconto, Double acrescimo) {
		this.id_itens_pedido = id_itens_pedido;
		this.pedido = pedido;
		this.produtos = produtos;
		this.quantidade = quantidade;
		this.valor = valor;
		this.desconto = desconto;
		this.acrescimo = acrescimo;
	}

	@Override
	public String toString() {
		return "ItensPedido [id_itens_pedido=" + id_itens_pedido + ", pedido=" + pedido + ", produtos=" + produtos
				+ ", quantidade=" + quantidade + ", valor=" + valor + ", desconto=" + desconto + ", acrescimo="
				+ acrescimo + "]";
	}

	public Long getId_itens_pedido() {
		return id_itens_pedido;
	}

	public void setId_itens_pedido(Long id_itens_pedido) {
		this.id_itens_pedido = id_itens_pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_itens_pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		return Objects.equals(id_itens_pedido, other.id_itens_pedido);
	}
	
	
	
	

}
