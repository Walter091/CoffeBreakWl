package com.example.coffeBreakWL.nucleo.enums;

public enum OpcaoCBEnum implements ItfcEnumBase{
	
	BOLO("BOLO", "BL", 0),
	CUZCUZ("CUZCUZ", "CZ", 1),
	CAFE("CAFÉ", "CF", 2),
	LEITE("LEITE", "LT", 3),
	BOLACHA("BOLACHA", "BL", 4),
	ACHOCOLATADO("ACHOCOLATADO", "AC", 5),
	MISTO("MISTO", "MS", 6);

	private String descricao;
	private String sigla;
	private int id;
	
	OpcaoCBEnum(String descricao, String sigla, int id) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.id = id;
	}
	
	// -------------------------------------------------------------------------------------

	public static OpcaoCBEnum obterPorID(Integer id) {
		OpcaoCBEnum result = null;
		if (id == 0) {
			result = OpcaoCBEnum.BOLO; 
		}
		if (id == 1) {
			return OpcaoCBEnum.CUZCUZ;
		}
		if (id == 2) {
			return OpcaoCBEnum.CAFE;
		}
		if (id == 3) {
			return OpcaoCBEnum.LEITE;
		}
		if (id == 4) {
			return OpcaoCBEnum.BOLACHA;
		}
		if (id == 5) {
			return OpcaoCBEnum.ACHOCOLATADO;
		}
		if (id == 6) {
			return OpcaoCBEnum.MISTO;
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
