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
import com.example.coffeBreakWL.entidade.RepositorioColaborador;
import com.example.coffeBreakWL.service.ServiceIntColaborador;

@Controller
public class ColaboradorController {
	
	@Autowired
	private ServiceIntColaborador servicoFuncionario;

	@Autowired
	private RepositorioColaborador repositorioColaborador;
	
	// -----------------------------------------------------------------------
	
	@GetMapping("/index")
	public String getColaboradores(Model model) {
		model.addAttribute("listaPessoas", repositorioColaborador.buscarTodosColaboradores());
		return "index"; 
	}
	
	@GetMapping("/incluirNovo")
	public String incluirNovoColaborador(@ModelAttribute("colaborador") Colaborador colaborador) {
		return "form";
	}
	
	@GetMapping("/index/{id}")
	public String alterarColaborador(@PathVariable("id") long id, Model model) {
		Optional<Colaborador> colabOptional = repositorioColaborador.findById(id);
		if (colabOptional.isEmpty()) {
			throw new IllegalArgumentException("Pessoa Inválida");
		}
		model.addAttribute("pessoa", colabOptional.get());
		
		return "form";
	}

	@GetMapping("/index/excluir/{id}")
	public String excluirColaborador(@PathVariable("id") long id, Model model) {
		Optional<Colaborador> colabOptional = repositorioColaborador.findById(id);
		if (colabOptional.isEmpty()) {
			throw new IllegalArgumentException("Pessoa Inválida");
		}
		
		repositorioColaborador.delete(colabOptional.get());
		return "redirect:/index";
	}

	
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("colaborador") Colaborador colaborador) {
		salvarColaborador(colaborador);
		return "redirect:/index";
	}
	

	@PostMapping("/inserir")
    public void salvarColaborador(@RequestBody Colaborador colaborador) {
		servicoFuncionario.doAntesDeInserir(colaborador);
        Colaborador obj = new Colaborador();
        obj.setId(colaborador.getId());
        obj.setNome(colaborador.getNome());
        obj.setCpf(colaborador.getCpf());
        obj.setOpcoesCb(colaborador.getOpcoesCb());
        
        repositorioColaborador.save(obj);				

    }

}
