package com.pegue.pague.api.enums;

public enum Operadora {

	VIVO("Vivo"),
	OI("Oi"),
	TIM("Tim"),
	CLARO("Claro");
	
	final String descricao;
	
	Operadora(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
