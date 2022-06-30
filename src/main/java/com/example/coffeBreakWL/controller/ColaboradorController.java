package com.example.coffeBreakWL.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.entidade.RepositorioColaborador;
import com.example.coffeBreakWL.service.ServiceIntColaborador;

@RestController
@RequestMapping("/colab")
public class ColaboradorController {
	
	@Autowired
	private ServiceIntColaborador servicoFuncionario;

	@Autowired
	private RepositorioColaborador repositorioColaborador;
	
	// -----------------------------------------------------------------------
	
	@GetMapping("/form")
	public List<Colaborador> getColaboradores() {
		return repositorioColaborador.buscarTodosColaboradores();
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

	
	// -----------------------------------------------------------------------
	
	
	// Adiciona novo funcionario
    @PostMapping("/add")
    public String novo(@Valid  Colaborador colaborador, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }

        salvarColaborador(colaborador);

        return "redirect:/home";
    }
    
    // Acessa o formulario de edição
    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") int id) {
    	Colaborador colaborador = repositorioColaborador.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
       
        model.addAttribute("colaborador", colaborador);
        return "AtualizaForm";
    }

    // Atualiza funcionario
    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Colaborador colaborador, BindingResult result, @PathVariable int id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }
        
        salvarColaborador(colaborador);
        return "redirect:/Home";
    }
}
