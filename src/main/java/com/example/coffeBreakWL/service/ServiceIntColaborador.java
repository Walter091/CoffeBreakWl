package com.example.coffeBreakWL.service;

import java.util.ArrayList;
import java.util.List;

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
			resultOpcao = validarAlimentosRepetidos(colaborador.getOpcoesCb()) ? true : false;
			
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
	public boolean validarAlimentosRepetidos(Integer opcao) throws Exception {
		List<Colaborador> objs = new ArrayList<>();
		objs = funcionarioRepositorio.validarAlimentoRepetido(opcao);
		if (objs.size() > 0) {
			ERRO = "OUTRO COLABORADOR JÁ ESCOLHEU A OPÇÃO: "
					+ getOpcoes(objs);
			return false;
		}
		return true;
	}
	
	public List<String> getOpcoes(List<Colaborador> objs){
		List<String> result = new ArrayList<>();
		for (int i = 0; i < objs.size(); i++) {
			result.add(objs.get(i).getOpcoesCbFormatado());
		}
		return result;
	}
	
	// ---------------------------------------------------------------------------------

	public String getERRO() {
		return ERRO;
	}

	public void setERRO(String eRRO) {
		ERRO = eRRO;
	}
	
}
