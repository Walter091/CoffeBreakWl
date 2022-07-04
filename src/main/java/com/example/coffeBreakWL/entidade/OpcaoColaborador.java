package com.example.coffeBreakWL.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.coffeBreakWL.nucleo.enums.TipoOpcaoEnum;

@Entity
@Table(name = "opcao")
public class OpcaoColaborador implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idOpcao;
			
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "IND_TIPO_OPCAO")
	private Integer tipoOpcao;
	
	// ---------------------------------------------------------

	public long getIdOpcao() {
		return idOpcao;
	}

	public void setIdOpcao(long idOpcao) {
		this.idOpcao = idOpcao;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTipoOpcao() {
		return tipoOpcao;
	}

	public String getTipoOpcaoFormatado() {
		if (tipoOpcao != null) {
			return TipoOpcaoEnum.obterPorID(tipoOpcao).getDescricao();			
		}
		return " ";
	}

	public void setTipoOpcao(Integer tipoOpcao) {
		this.tipoOpcao = tipoOpcao;
	}	
	
}
