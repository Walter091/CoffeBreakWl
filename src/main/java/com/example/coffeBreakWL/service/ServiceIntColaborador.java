package com.example.coffeBreakWL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.entidade.RepositorioColaborador;
import com.example.coffeBreakWL.nucleo.enums.OpcaoCBEnum;
import com.example.coffeBreakWL.nucleo.validacoes.ValidationCpf;

@Service
public class ServiceIntColaborador implements ServiceColaborador {

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
	
	public void doAntesDeInserir(Colaborador colaborador) {
		try {
			isCpfValido(colaborador.getCpf());
//			validarAlimentosRepetidos(colaborador.getOpcoesCb());
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Override
	public void isCpfValido(String cpf) throws Exception{
		ValidationCpf validaCpf = new ValidationCpf();
		if (validaCpf.isValid(cpf, null)) {
			 throw new Exception("CPF INVÁLIDO!! ");
		} else if (funcionarioRepositorio.validarCpfRepetido(cpf)) {
			throw new Exception("CPF JÁ CADASTRADO!! ");
		}
	}

	@Override
	public void validarAlimentosRepetidos(List<OpcaoCBEnum> opcoes) throws Exception {
		for (int i = 0; i < opcoes.size(); i++) {
			if (opcoes.get(i) == opcoes.get(i+1)) {
				throw new Exception("ALIMENTOS REPETIDOS!! POR FAVOR ALTERE SUA OPÇÃO");
			}
		}
	}
	
}
