package com.example.coffeBreakWL.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.coffeBreakWL.entidade.Colaborador;

@Repository
public interface RepositorioColaborador extends CrudRepository<Colaborador, Long> {
	
	@Query(value = "SELECT * FROM colaborador", nativeQuery = true)
	public List<Colaborador> buscarTodosColaboradores();

	@Query(value = "SELECT * FROM colaborador WHERE CPF = :cpf", nativeQuery = true)
	public List<Colaborador> validarCpfRepetido(@Param("cpf") String cpf);

	@Query(value = "SELECT * FROM colaborador WHERE IND_OPCOES_CB = :opcao", nativeQuery = true)
	public List<Colaborador> validarAlimentoRepetido(@Param("opcao") int opcao);

	@Query(value = "SELECT * FROM colaborador WHERE ID_COLABORADOR = :id", nativeQuery = true)
	public Colaborador getById(@Param("id") long id);
		
	// --------------------------------------------------------------------------------------------
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM colaborador WHERE ID_COLABORADOR = :id", nativeQuery = true)
	public void excluir(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO colaborador (ID_COLABORADOR, NOME, CPF, IND_OPCOES_CB) VALUES (:id, :nome, :cpf, :opcoesCb)", nativeQuery = true)
	public void salvar(@Param("id") Long id, @Param("nome") String nome, @Param("cpf") String cpf, @Param("opcoesCb") Integer opcoes);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE colaborador SET NOME= :nome, CPF= :cpf, IND_OPCOES_CB= :opcoesCb WHERE ID_COLABORADOR= :id", nativeQuery = true)
	public void alterar(@Param("id") Long id, @Param("nome") String nome, @Param("cpf") String cpf, @Param("opcoesCb") Integer opcoes);
		
}
