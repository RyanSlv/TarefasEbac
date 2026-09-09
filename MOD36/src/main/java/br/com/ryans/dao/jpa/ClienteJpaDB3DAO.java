package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.ryans.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2,Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}
}