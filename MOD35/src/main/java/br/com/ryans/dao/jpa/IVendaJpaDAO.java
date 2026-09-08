package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.IGenericJpaDAO;
import br.com.ryans.domain.jpa.VendaJpa;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa, Long>{

	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

	public VendaJpa consultarComCollection(Long id);
}
