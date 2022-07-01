package com.example.coffeBreakWL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.entidade.RepositorioColaborador;
import com.example.coffeBreakWL.nucleo.enums.StatusFormularioEnum;
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
		
	public boolean doAntesDeInserir(Colaborador colaborador, StatusFormularioEnum status) {
		boolean resultCpf = false;
		boolean resultOpcao = false;
		try {
			
			resultCpf = isCpfValido(colaborador.getCpf(), status) ? true : false;
			resultOpcao = validarAlimentosRepetidos(colaborador.getOpcoesCb(), status) ? true : false;
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return resultCpf && resultOpcao == true ? true : false;
	}
	
	@Override
	public boolean isCpfValido(String cpf, StatusFormularioEnum status) throws Exception{
		ValidationCpf validaCpf = new ValidationCpf();
		if (!validaCpf.isValid(cpf, null)) {
			 ERRO = "CPF INVÁLIDO!";
			 return false;
		} 
		if (status == StatusFormularioEnum.ALTERAR) {
			return true;
		} else if (funcionarioRepositorio.validarCpfRepetido(cpf).size() > 0) {
			ERRO = "CPF JÁ CADASTRADO!";
			return false;
		} 
		return true;
	}

	@Override
	public boolean validarAlimentosRepetidos(Integer opcao, StatusFormularioEnum status) throws Exception {
		if (funcionarioRepositorio.validarAlimentoRepetido(opcao).size() > 0) {
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
