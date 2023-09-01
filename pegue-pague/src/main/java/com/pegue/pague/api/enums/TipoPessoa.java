package com.pegue.pague.api.enums;

public enum TipoPessoa {

	FISICA("Física"), 
	JURIDICA("Jurídica");

//	private final Class<?> group;
	final String descricao;

	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
