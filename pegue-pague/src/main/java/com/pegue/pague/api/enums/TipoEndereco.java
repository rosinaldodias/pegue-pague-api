package com.pegue.pague.api.enums;

public enum TipoEndereco {
	
	COMERCIAL("Comercial"),
	RESIDENCIA("Residencial");

	final String descricao;
	
	TipoEndereco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
