package com.example.coffeBreakWL.natives;

import java.util.List;
import java.util.Map;

import com.example.coffeBreakWL.entidade.Colaborador;

import io.github.gasparbarancelli.NativeQuery;

public interface UserNativeQuery extends NativeQuery {

	  List<Colaborador> buscarTodosColaboradores();
	  	
	  Colaborador buscarPorId(Long id);
	  
	  Colaborador buscarPorCpf(String cpf);

	  List<Colaborador> buscarPorMapeamento(Map<String, Object> params);
	  
//	  @NativeQuerySql("SELECT ID_COLABORADOR as \"id\", NOME as \"name\" FROM colaborador")
//	  List<Colaborador> findBySqlInline();
//
//	  
//	  List<Colaborador> findUsersByFilter(@NativeQueryParam(value = "filter", addChildren = true) UserFilter filter);
//
//	  List<Colaborador> findActiveUsers(PageRequest pageRequest);
//
//	  List<Colaborador> findActiveUsersWithSort(Sort sort);
//
//	  Page<Colaborador>  findActiveUsersWithPage(PageRequest pageRequest);
//	  
//	  Colaborador findUserById(@NativeQueryParam(value = "id") Number id);
//	  
//	  List<Colaborador> getUsersId();
//	  
//	  String getUserName(Number id);
//
//	  Optional<String> getOptionalUserName(Number id);
//
//	  Optional<Colaborador> findOptionalUserById(@NativeQueryParam(value = "id") Number id);
	  
}