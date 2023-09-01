package com.pegue.pague.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pegue.pague.api.enums.FormaPagamento;
import com.pegue.pague.api.enums.StatusPedido;
import com.pegue.pague.api.enums.TipoPedido;
@Entity
public class Pedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_pedido;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private TipoPedido tipoPedido;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private FormaPagamento formaPagamento;
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private Date data;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Pessoa cliente;
	@ManyToOne
	@JoinColumn(name = "id_vendedor")
	private Pessoa vendedor;
	@Enumerated(EnumType.STRING)
	@Column(length = 40)
	private StatusPedido status;
	@OneToOne
	private Endereco enderecoEntrega;
	private Double valorFrete;
	@ManyToOne
	@JoinColumn(name = "id_transportadora")
	private Transportadora transportadora;
	@Column(length = 100)
	private String rastreamento;
	@Column(length = 200)
	private String informacaoAdicional;
	@OneToMany
	private List<ItensPedido> itens;
	public Long getCodigo() {
		return id_pedido;
	}
	
	public Pedido() {
	}
	
	
	//Não se usa list nos parametros 
	public Pedido(Long id_pedido, TipoPedido tipoPedido, FormaPagamento formaPagamento, Date data, Pessoa cliente,
			Pessoa vendedor, StatusPedido status, Endereco enderecoEntrega, Double valorFrete,
			Transportadora transportadora, String rastreamento, String informacaoAdicional) {
		this.id_pedido = id_pedido;
		this.tipoPedido = tipoPedido;
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.status = status;
		this.enderecoEntrega = enderecoEntrega;
		this.valorFrete = valorFrete;
		this.transportadora = transportadora;
		this.rastreamento = rastreamento;
		this.informacaoAdicional = informacaoAdicional;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", tipoPedido=" + tipoPedido + ", formaPagamento=" + formaPagamento
				+ ", data=" + data + ", cliente=" + cliente + ", vendedor=" + vendedor + ", status=" + status
				+ ", enderecoEntrega=" + enderecoEntrega + ", valorFrete=" + valorFrete + ", transportadora="
				+ transportadora + ", rastreamento=" + rastreamento + ", informacaoAdicional=" + informacaoAdicional
				+ ", itens=" + itens + "]";
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Pessoa getVendedor() {
		return vendedor;
	}

	public void setVendedor(Pessoa vendedor) {
		this.vendedor = vendedor;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public String getRastreamento() {
		return rastreamento;
	}

	public void setRastreamento(String rastreamento) {
		this.rastreamento = rastreamento;
	}

	public String getInformacaoAdicional() {
		return informacaoAdicional;
	}

	public void setInformacaoAdicional(String informacaoAdicional) {
		this.informacaoAdicional = informacaoAdicional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id_pedido, other.id_pedido);
	}
	
	
	
}
