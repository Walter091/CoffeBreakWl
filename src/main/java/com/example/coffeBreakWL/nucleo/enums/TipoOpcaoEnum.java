package com.example.coffeBreakWL.nucleo.enums;

public enum TipoOpcaoEnum implements ItfcEnumBase{
	
	COMIDA("COMIDA", "CM", 0),
	BEBIDA("BEBIDA", "BB", 1);
	
	private String descricao;
	private String sigla;
	private int id;
	
	TipoOpcaoEnum(String descricao, String sigla, int id) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.id = id;
	}
	
	// -------------------------------------------------------------------------------------

	public static TipoOpcaoEnum obterPorID(Integer id) {
		TipoOpcaoEnum result = null;
		if (id == 0) {
			result = TipoOpcaoEnum.COMIDA; 
		}
		if (id == 1) {
			return TipoOpcaoEnum.BEBIDA;
		}
		return result;
	}
	
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
