package com.pegue.pague.api.enums;

public enum TipoTelefone {
	RESIDENCIAL("Residencial"),
	TRABALHO("Trabalho"),
	RECADO("Recado");
	
	final String descricao;
	
	TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
