package br.com.ryans.dao;

import br.com.ryans.dao.generic.jpa.GenericJpaDAO;
import br.com.ryans.dao.jpa.IVendaJpaDAO;
import br.com.ryans.domain.jpa.VendaJpa;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
