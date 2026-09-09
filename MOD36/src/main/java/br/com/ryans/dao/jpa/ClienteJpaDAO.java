package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.ryans.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa,Long> implements IClienteJpaDAO<ClienteJpa>{

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}
}