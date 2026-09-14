package br.com.ryans.service;

import java.util.Collection;

import br.com.ryans.dao.ClienteDAO;
import br.com.ryans.dao.IClienteDAO;
import br.com.ryans.domain.Cliente;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public void excluir(Cliente cliente) {
        clienteDAO.excluir(cliente);
    }

    @Override
    public Cliente alterar(Cliente cliente) {
        return clienteDAO.alterar(cliente);
    }

    @Override
    public Cliente consultar(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clienteDAO.buscarTodos();
    }
}