package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.GenericJpaDAO;
import br.com.ryans.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
