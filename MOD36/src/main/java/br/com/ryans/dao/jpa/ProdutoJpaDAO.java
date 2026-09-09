package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.GenericJpaDAO;
import br.com.ryans.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
