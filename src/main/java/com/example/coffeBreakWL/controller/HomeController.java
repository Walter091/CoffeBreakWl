package com.example.coffeBreakWL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.entidade.RepositorioColaborador;

@Controller
public class HomeController {
	
	@Autowired
	private RepositorioColaborador repositorioColaborador;
	
	@GetMapping("/home")
    public String home(Model model) {
    	List<Colaborador> colaboradores = (List<Colaborador>) repositorioColaborador.findAll();
    	
        model.addAttribute("colaboradores", colaboradores);
        return "home";
    }
}
