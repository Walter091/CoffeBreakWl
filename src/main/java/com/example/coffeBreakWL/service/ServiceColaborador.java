package com.example.coffeBreakWL.service;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.nucleo.enums.StatusFormularioEnum;

public interface ServiceColaborador {
	
	Iterable<Colaborador> buscarTodos();
	
	boolean isCpfValido(String cpf, StatusFormularioEnum status) throws Exception;
	
//	boolean validarAlimentosRepetidos(List<OpcaoColaborador> opcoes) throws Exception;

	boolean validarAlimentosRepetidos(Integer opcoes) throws Exception;

}

