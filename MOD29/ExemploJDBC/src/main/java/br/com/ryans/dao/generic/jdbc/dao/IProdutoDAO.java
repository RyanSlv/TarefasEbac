/**
 * 
 */
package br.com.ryans.dao.generic.jdbc.dao;

import java.util.List;

import br.com.ryans.domain.Produto;

/**
 * 
 */
public interface IProdutoDAO {

	Integer cadastrar(Produto produto) throws Exception;
	
	Integer atualizar(Produto produto) throws Exception;
	
	Produto buscar(Integer id) throws Exception;
	
	List<Produto> buscarTodos() throws Exception;
	
	Integer excluir(Produto produto) throws Exception;
}
