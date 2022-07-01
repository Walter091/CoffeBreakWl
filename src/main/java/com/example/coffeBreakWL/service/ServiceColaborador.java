package com.example.coffeBreakWL.service;

import com.example.coffeBreakWL.entidade.Colaborador;

public interface ServiceColaborador {
	
	Iterable<Colaborador> buscarTodos();
	
	void inserir(Colaborador colaborador) throws Exception;
	
	boolean isCpfValido(String cpf) throws Exception;
	
	boolean validarAlimentosRepetidos(Integer opcao) throws Exception;
}

