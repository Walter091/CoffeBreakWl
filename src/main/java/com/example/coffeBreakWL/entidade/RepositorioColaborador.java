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
	public List<Colaborador> validarCpfRepetido(@Param("cpf") String cpf);

	@Query(value = "SELECT * FROM colaborador WHERE IND_OPCOES_CB = :opcao", nativeQuery = true)
	public List<Colaborador> validarAlimentoRepetido(@Param("opcao") int opcao);

	@Query(value = "SELECT * FROM colaborador WHERE ID_COLABORADOR = :id", nativeQuery = true)
	public Colaborador getById(@Param("id") int id);
	
	// --------------------------------------------------------------------------------------------
	
	@Query(value = "DELETE FROM colaborador WHERE ID_COLABORADOR = :id", nativeQuery = true)
	public void excluir(@Param("id") int id);
	
	@Query(value = "INSERT INTO colaborador (NOME, CPF, IND_OPCOES_CB) VALUES (:obj.nome, :obj.cpf, :obj.opcoesCb)", nativeQuery = true)
	public void salvar(@Param("obj") Colaborador obj);
	
	@Query(value = "UPDATE colaborador SET NOME=:obj.nome, CPF=:obj.cpf, IND_OPCOES_CB=:obj.opcoesCb WHERE ID_COLABORADOR= :obj.id;)", nativeQuery = true)
	public void alterar(@Param("obj") Colaborador obj);
		
}
