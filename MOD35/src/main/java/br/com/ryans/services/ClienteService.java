package br.com.ryans.services;

import br.com.ryans.dao.IClienteDAO;
import br.com.ryans.domain.Cliente;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.MaisDeUmRegistroException;
import br.com.ryans.exceptions.TableException;
import br.com.ryans.services.generic.GenericService;

public class ClienteService
        extends GenericService<Cliente, Long>
        implements IClienteService {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            e.printStackTrace();
            return null;
        }
    }
}