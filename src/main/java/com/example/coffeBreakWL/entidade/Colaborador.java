package com.example.coffeBreakWL.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.coffeBreakWL.nucleo.enums.OpcaoCBEnum;
import com.example.coffeBreakWL.nucleo.utils.StringUtils;

@Entity
@Table(name = "colaborador")
public class Colaborador implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COLABORADOR")
	private long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
//	@Column(name = "IND_OPCOES_CB")
//	@OneToMany
//    private List<OpcaoColaborador> opcoesCb;

	@Column(name = "IND_OPCOES_CB")
	private Integer opcoesCb;
	
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
	
	public String getCpfFormatado() {
		return cpf == null ? " -- " : StringUtils.formatarCpf(cpf);
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getOpcoesCb() {
		return opcoesCb;
	}

	public String getOpcoesCbFormatado() {
		return opcoesCb == null ? " " : OpcaoCBEnum.obterPorID(opcoesCb).getDescricao();
	}

	public void setOpcoesCb(Integer opcoesCb) {
		this.opcoesCb = opcoesCb;
	}

//	public List<OpcaoColaborador> getOpcoesCb() {
//		return opcoesCb;
//	}
//
//	public void setOpcoesCb(List<OpcaoColaborador> opcoesCb) {
//		this.opcoesCb = opcoesCb;
//	}

	
}
