package com.example.coffeBreakWL.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.coffeBreakWL.entidade.OpcaoColaborador;
import com.example.coffeBreakWL.nucleo.enums.StatusFormularioEnum;
import com.example.coffeBreakWL.service.ServiceIntOpcaoColaborador;

@Controller
public class OpcaoColaboradorController {

	@Autowired
	private ServiceIntOpcaoColaborador servicoOpcaoColaborador; 

	@SuppressWarnings("unused")
	private StatusFormularioEnum statusFormulario;
	
	@GetMapping("/cadastroOpcao")
	public String getCadastroOpcao(@ModelAttribute("opcaoColaborador") OpcaoColaborador opcaoColaborador) {		
		return "cadastroOpcao"; 
	}
	
	@GetMapping("/planilhaOpcao")
	public String getPlanilhaOpcao(Model model) {
		model.addAttribute("listaOpcao", servicoOpcaoColaborador.buscarTodasOpcoes());
		return "planilhaOpcao";
	}
	
	@PostMapping("/salvarOpcao")
    public String salvarOpcaoColaborador(@ModelAttribute("opcaoColaborador") OpcaoColaborador opcaoColaborador) {        
		servicoOpcaoColaborador.salvarOpcaoColaborador(opcaoColaborador);
		return "redirect:/index";

    }

	@GetMapping("/indexOpcao/alterar/{id}")
	public String alterarColaborador(@PathVariable("id") long id, Model model) {
		statusFormulario = StatusFormularioEnum.ALTERAR;
		Optional<OpcaoColaborador> opcaobOptional = servicoOpcaoColaborador.buscarPorId(id);
		if (opcaobOptional.isEmpty()) {
			throw new IllegalArgumentException("Opção Inválida");
		}
		model.addAttribute("opcao", opcaobOptional.get());
		
		return "cadastroOpcao";
	}

	@GetMapping("/indexOpcao/excluir/{id}")
	public String excluirColaborador(@PathVariable("id") long id, Model model) {
		statusFormulario = StatusFormularioEnum.EXCLUIR;
		OpcaoColaborador obj = servicoOpcaoColaborador.buscarPorIdQN(id);
		if (obj == null) {
			throw new IllegalArgumentException("Pessoa Inválida");
		}
		
		servicoOpcaoColaborador.excluir(obj.getIdOpcao());
		return "redirect:/index";
	}

}
