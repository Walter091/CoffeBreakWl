package com.example.coffeBreakWL.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.nucleo.enums.StatusFormularioEnum;
import com.example.coffeBreakWL.nucleo.validacoes.ValidationCpf;
import com.example.coffeBreakWL.repositorios.RepositorioColaborador;

@Service
public class ServiceIntColaborador implements ServiceColaborador {

	public String ERRO = " ";

	@Autowired
	private RepositorioColaborador repositorioColaborador;
		
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
		} else if (repositorioColaborador.validarCpfRepetido(cpf).size() > 0) {
			ERRO = "CPF JÁ CADASTRADO!";
			return false;
		} 
		return true;
	}
	
	@Override
	public boolean validarAlimentosRepetidos(Integer opcoes) throws Exception {
		List<Colaborador> objs = new ArrayList<>();
		if (opcoes != null) {
			objs.addAll(repositorioColaborador.validarAlimentoRepetido(opcoes));
			if (objs.size() > 0) {
				ERRO = "OUTRO COLABORADOR JÁ ESCOLHEU A OPÇÃO: "
						+ getOpcoes(objs);
				return false;
			}
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

	public Iterable<Colaborador> buscarTodos() {
		return repositorioColaborador.buscarTodosColaboradores();
	}
		
	public Colaborador buscarPorIdQN(long id){
		return repositorioColaborador.getById(id);
	}

	public Optional<Colaborador> buscarPorId(long id){
		return repositorioColaborador.findById(id);
	}
	
	public void salvar(Colaborador obj) {
		repositorioColaborador.salvar(obj.getId(), obj.getNome(), obj.getCpf(), obj.getOpcoesCb()); 
	}
	
	public void excluir(long id) {
		repositorioColaborador.excluir(id);	
	}
	
	public void alterar(Colaborador colaborador) {
		repositorioColaborador.alterar(colaborador.getId(), colaborador.getNome(), colaborador.getCpf(), colaborador.getOpcoesCb());
	}
	
	// ---------------------------------------------------------------------------------

	public String getERRO() {
		return ERRO;
	}

	public void setERRO(String eRRO) {
		ERRO = eRRO;
	}
	
}
