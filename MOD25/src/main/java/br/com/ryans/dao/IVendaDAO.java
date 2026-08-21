/**
 * 
 */
package br.com.ryans.dao;

import br.com.ryans.dao.generics.IGenericDAO;
import br.com.ryans.domain.Venda;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

/**
 * 
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {
	
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;

}
