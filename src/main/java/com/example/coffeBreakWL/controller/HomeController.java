package com.example.coffeBreakWL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.entidade.RepositorioColaborador;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private RepositorioColaborador repositorioColaborador;
	
	@GetMapping()
    public String home(Model model) {
    	List<Colaborador> colaboradores = (List<Colaborador>) repositorioColaborador.findAll();
    	
        model.addAttribute("colaboradores", colaboradores);
        return "home";
    }
}
