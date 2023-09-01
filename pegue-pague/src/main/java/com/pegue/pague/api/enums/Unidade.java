package com.pegue.pague.api.enums;

public enum Unidade {
	UNIDADE("Unidade"),
	CARTELA("Cartela"),
	CAIXA("Caixa"),
	DUZIA("Dúzia"),
	GROSA("Grosa"),
	PAR("Par"),
	PECA("Peça"),
	PACOTE("Pacote"),
	ROLO("Rolo"),
	KILOGRAMA("KG"),
	GRAMA("Grama"),
	KIT("Kit"),
	JOGO("Jogo");
	
	final String descricao;
	
	Unidade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
