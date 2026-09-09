package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.ryans.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa,Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}
}