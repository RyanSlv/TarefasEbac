/**
 * 
 */
package br.com.ryans.dao.generics;

import br.com.ryans.dao.Persistente;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 */
public interface IGenericDAO <T extends Persistente, E extends Serializable> {
	
	E getChave(T emtity) throws TipoChaveNaoEncontradaException;

	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
	
	public void excluir(E valor);
	
	public void alterar(T entity) throws TipoChaveNaoEncontradaException;
	
	public T consultar(E valor);
	
	public Collection<T> buscarTodos();
}
