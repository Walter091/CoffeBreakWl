package com.example.coffeBreakWL.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.coffeBreakWL.entidade.OpcaoColaborador;

public interface RepositorioOpcaoColaborador extends CrudRepository<OpcaoColaborador, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO opcao (IND_OPCOES_CB, NOME, IND_TIPO_OPCAO) VALUES (:id, :nome, :tipo)", nativeQuery = true)
	public void salvar(@Param("id") Long id, @Param("nome") String nome, @Param("tipo") Integer tipo);
	
	@Query(value = "SELECT * FROM opcao", nativeQuery = true)
	public List<OpcaoColaborador> buscarTodasOpcoes();
	
	@Query(value = "SELECT * FROM opcao", nativeQuery = true)
	public List<OpcaoColaborador> getListaOpcoes();

	@Query(value = "SELECT * FROM opcao WHERE IND_OPCOES_CB = :id", nativeQuery = true)
	public OpcaoColaborador getById(@Param("id") long id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM opcao WHERE IND_OPCOES_CB = :id", nativeQuery = true)
	public void excluir(@Param("id") Long id);
	
}
