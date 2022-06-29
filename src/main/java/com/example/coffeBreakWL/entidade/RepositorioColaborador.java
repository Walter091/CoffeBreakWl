package com.example.coffeBreakWL.entidade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioColaborador extends CrudRepository<Colaborador, Long> {
	
}
