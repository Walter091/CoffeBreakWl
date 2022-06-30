package com.example.coffeBreakWL.entidade;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioColaborador extends CrudRepository<Colaborador, Long> {
	
	@Query(value = "SELECT * FROM colaborador", nativeQuery = true)
	public List<Colaborador> buscarTodosColaboradores();

	@Query(value = "SELECT * FROM colaborador WHERE CPF = :cpf", nativeQuery = true)
	public boolean validarCpfRepetido(@Param("cpf") String cpf);

	@Query(value = "SELECT IND_OPCOES_CB FROM colaborador WHERE IND_OPCOES_CB = :opcao", nativeQuery = true)
	public boolean validarAlimentoRepetido(@Param("opcao") int opcao);

	@Query(value = "SELECT * FROM colaborador WHERE ID_COLABORADOR = :id", nativeQuery = true)
	public Colaborador findById(@Param("id") int id);

}
