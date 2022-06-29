package com.example.coffeBreakWL.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.coffeBreakWL.nucleo.enums.OpcaoCBEnum;

@Entity
public class Colaborador implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String cpf;
	private List<Integer> opcoesCb;
	
	// --------------------------------------------------------------------

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<OpcaoCBEnum> getOpcoesCb() {
		List<OpcaoCBEnum> result = new ArrayList<OpcaoCBEnum>();
		for (int i = 0; i < opcoesCb.size(); i++) {
			result.add(OpcaoCBEnum.obterPorID(opcoesCb.get(i)));
		}
		return result;
	}

	public void setOpcoesCb(List<Integer> opcoesCb) {
		this.opcoesCb = opcoesCb;
	}
	
}
