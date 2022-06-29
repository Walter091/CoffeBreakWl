package com.example.coffeBreakWL.service;

import java.util.List;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.nucleo.enums.OpcaoCBEnum;

public interface ServiceColaborador {
	
	Iterable<Colaborador> buscarTodos();
	
	void inserir(Colaborador colaborador) throws Exception;
	
	void isCpfValido(String cpf) throws Exception;
	
	void validarAlimentosRepetidos(List<OpcaoCBEnum> opcoes) throws Exception;
}

