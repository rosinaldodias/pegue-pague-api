package com.pegue.pague.api.enums;

public enum StatusPedido {
	PENDENTE("Pendente"),
	QUITADO("Quitado"), 
	CANCELADO("Cancelado");
	
	final String descricao;
	
	StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
