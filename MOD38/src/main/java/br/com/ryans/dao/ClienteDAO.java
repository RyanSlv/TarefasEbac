package br.com.ryans.dao;

import javax.enterprise.context.ApplicationScoped;

import br.com.ryans.dao.generic.GenericDAO;
import br.com.ryans.domain.Cliente;

@ApplicationScoped
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {
	
	public ClienteDAO() {
		super(Cliente.class);
	}

}
