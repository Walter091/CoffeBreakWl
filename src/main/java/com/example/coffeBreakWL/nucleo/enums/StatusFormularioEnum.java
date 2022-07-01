package com.example.coffeBreakWL.nucleo.enums;

public enum StatusFormularioEnum implements ItfcEnumBase{
	
	INCLUIR("INCLUIR", "IN", 0),
	ALTERAR("ALTERAR", "AL", 1),
	VIZUALIZAR("VIZUALIZAR", "VI", 2);

	private String descricao;
	private String sigla;
	private int id;
	
	private StatusFormularioEnum(String descricao, String sigla, int id) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.id = id;
	}
	
	// -------------------------------------------------------------------------------------

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String getSigla() {
		return sigla;
	}

	@Override
	public int getId() {
		return id;
	}
	
}
