package br.com.ryans.dao;

import br.com.ryans.dao.generic.IGenericDAO;
import br.com.ryans.domain.Venda;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
