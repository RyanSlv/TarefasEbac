package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.ryans.domain.jpa.ClienteJpa;

public abstract class ClienteJpaDB3DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa.class);
	}
}
