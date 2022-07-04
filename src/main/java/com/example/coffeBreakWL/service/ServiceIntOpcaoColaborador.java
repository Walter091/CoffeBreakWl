package com.example.coffeBreakWL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeBreakWL.entidade.OpcaoColaborador;
import com.example.coffeBreakWL.repositorios.RepositorioOpcaoColaborador;

@Service
public class ServiceIntOpcaoColaborador implements ServiceOpcaoColaborador{
	
	@Autowired
	private RepositorioOpcaoColaborador repositorioOpcaoColaborador;
	
	public void salvarOpcaoColaborador(OpcaoColaborador obj) {
		repositorioOpcaoColaborador.salvar(obj.getIdOpcao(), obj.getNome(), obj.getTipoOpcao());
	}
	
	public List<OpcaoColaborador> buscarTodasOpcoes() {
		return repositorioOpcaoColaborador.buscarTodasOpcoes();
	}

	public List<OpcaoColaborador> getListaOpcoes(){
		return repositorioOpcaoColaborador.getListaOpcoes();
	}
	
	public Optional<OpcaoColaborador> buscarPorId(long id){
		return repositorioOpcaoColaborador.findById(id);
	}
	
	public OpcaoColaborador buscarPorIdQN(long id){
		return repositorioOpcaoColaborador.getById(id);
	}
	
	public void excluir(long id) {
		repositorioOpcaoColaborador.excluir(id);	
	}
	
	
}
