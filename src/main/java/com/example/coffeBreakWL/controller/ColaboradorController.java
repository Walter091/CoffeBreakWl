package com.example.coffeBreakWL.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.nucleo.enums.StatusFormularioEnum;
import com.example.coffeBreakWL.service.ServiceIntColaborador;

@Controller
public class ColaboradorController {
	
	@Autowired
	private ServiceIntColaborador servicoColaborador;

//	@Autowired
//	private ServiceIntOpcaoColaborador servicoOpcaoColaborador; 
	
	private StatusFormularioEnum statusFormulario;

	// -----------------------------------------------------------------------
	
	@GetMapping("/index")
	public String getColaboradores(Model model) {
		statusFormulario = StatusFormularioEnum.VIZUALIZAR;
		model.addAttribute("listaPessoas", servicoColaborador.buscarTodos());
		
		return "index"; 
	}
	
	@GetMapping("/incluirNovo")
	public String incluirNovoColaborador(@ModelAttribute("colaborador") Colaborador colaborador, Model model) {
//		model.addAttribute("opcoesAlimentos", servicoOpcaoColaborador.getListaOpcoes());
		statusFormulario = StatusFormularioEnum.INCLUIR;
		return "form";
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("colaborador") Colaborador colaborador, Model model) {
		if (statusFormulario == StatusFormularioEnum.ALTERAR) {
			if (servicoColaborador.doAntesDeInserir(colaborador, statusFormulario)) {
				servicoColaborador.alterar(colaborador);				
			} else {
				String msgErro = servicoColaborador.getERRO();
				model.addAttribute("msgError", msgErro);
				
				return "form";
			}
		} else if (msgValidacaoSalvamento(colaborador)) {
			return "redirect:/index";
		} else {
			String msgErro = servicoColaborador.getERRO();
			model.addAttribute("msgError", msgErro);
			
			return "form";
		}
		return "redirect:/index";
	}
	
	@PostMapping("/inserir")
    public void salvarColaborador(@RequestBody Colaborador colaborador) {        
        servicoColaborador.salvar(colaborador);

    }

	@GetMapping("/index/alterar/{id}")
	public String alterarColaborador(@PathVariable("id") long id, Model model) {
		statusFormulario = StatusFormularioEnum.ALTERAR;
		Optional<Colaborador> colabOptional = servicoColaborador.buscarPorId(id);
		if (colabOptional.isEmpty()) {
			throw new IllegalArgumentException("Pessoa Inválida");
		}
		model.addAttribute("colaborador", colabOptional.get());
		
		return "form";
	}

	@GetMapping("/index/excluir/{id}")
	public String excluirColaborador(@PathVariable("id") long id, Model model) {
		statusFormulario = StatusFormularioEnum.EXCLUIR;
		Colaborador obj = servicoColaborador.buscarPorIdQN(id);
		if (obj == null) {
			throw new IllegalArgumentException("Pessoa Inválida");
		}
		
		servicoColaborador.excluir(obj.getId());
		return "redirect:/index";
	}

	public boolean msgValidacaoSalvamento(Colaborador colaborador) {
		if (servicoColaborador.doAntesDeInserir(colaborador, statusFormulario)) {
			salvarColaborador(colaborador);			
			return true;
		}
		return false;
	}
	
}
