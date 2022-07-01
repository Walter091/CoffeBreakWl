package com.example.coffeBreakWL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.entidade.RepositorioColaborador;
import com.example.coffeBreakWL.nucleo.validacoes.ValidationCpf;

@Service
public class ServiceIntColaborador implements ServiceColaborador {

	public String ERRO = " ";

	@Autowired
	private RepositorioColaborador funcionarioRepositorio;

	@Override
	public Iterable<Colaborador> buscarTodos() {
		return funcionarioRepositorio.findAll();
	}
	
	@Override
	public void inserir(Colaborador colaborador){
		doAntesDeInserir(colaborador);
	}
	
	public boolean doAntesDeInserir(Colaborador colaborador) {
		boolean resultCpf = false;
		boolean resultOpcao = false;
		try {
			
			resultCpf = isCpfValido(colaborador.getCpf()) ? true : false;
			resultOpcao = validarAlimentosRepetidos(colaborador.getOpcoesCb()) ? true : false;
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return resultCpf && resultOpcao == true ? true : false;
	}
	
	@Override
	public boolean isCpfValido(String cpf) throws Exception{
		ValidationCpf validaCpf = new ValidationCpf();
		if (!validaCpf.isValid(cpf, null)) {
			 ERRO = "CPF INVÁLIDO!";
			 return false;
		} else if (funcionarioRepositorio.validarCpfRepetido(cpf) == null) {
			ERRO = "CPF JÁ CADASTRADO!";
			return false;
		} 
		return true;
	}

	@Override
	public boolean validarAlimentosRepetidos(Integer opcao) throws Exception {
		if (funcionarioRepositorio.validarAlimentoRepetido(opcao) != null) {
			ERRO = "OUTRO COLABORADOR JÁ ESCOLHEU ESTA OPÇÃO!";
			return false;
		}
		return true;
	}
	// ---------------------------------------------------------------------------------

	public String getERRO() {
		return ERRO;
	}

	public void setERRO(String eRRO) {
		ERRO = eRRO;
	}
	
}
