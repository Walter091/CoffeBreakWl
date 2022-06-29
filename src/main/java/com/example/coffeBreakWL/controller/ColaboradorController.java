package com.example.coffeBreakWL.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeBreakWL.entidade.Colaborador;
import com.example.coffeBreakWL.natives.UserNativeQuery;

@RestController
@RequestMapping("colaborador")
public class ColaboradorController {
	
//	@Autowired
//	private ServiceIntColaborador servicoFuncionario;
	
	@Autowired 
	private UserNativeQuery userNativeQuery;
	
//	@GetMapping
//	public ResponseEntity<Iterable<Colaborador>> buscar() {
//		return ResponseEntity.ok(servicoFuncionario.buscarTodos());
//	}
//
//	@PostMapping()
//	public ResponseEntity<Colaborador> inserir(@RequestBody Colaborador colaborador) {
//		servicoFuncionario.inserir(colaborador);
//		return ResponseEntity.ok(colaborador);
//	}

	@GetMapping
	public List<Colaborador> getColaboradores() {
		return userNativeQuery.buscarTodosColaboradores();
	}

	@SuppressWarnings("unchecked")
	@GetMapping("porId")
	public List<Colaborador> getPorId() {
		Colaborador obj = new Colaborador();
		return (List<Colaborador>) userNativeQuery.buscarPorId(obj.getId());
	}

	@GetMapping("map")
	public List<Colaborador> buscarPorMapeamento() {
	   Map<String, Object> map = new HashMap<>();
	   map.put("ID_COLABORADOR", 1);
	   map.put("NOME", "Gaspar");
	   map.put("CPF", "14214485483");
	   
	   return userNativeQuery.buscarPorMapeamento(map);
	}


}
