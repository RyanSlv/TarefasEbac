package br.com.ryans.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.ryans.dao.IClienteDAO;
import br.com.ryans.domain.Cliente;
import br.com.ryans.services.generic.GenericService;

@ApplicationScoped
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    @Inject
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }
}