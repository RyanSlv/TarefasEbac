package br.com.ryans.Service;

import br.com.ryans.DAO.IClienteDAO;

public class ClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
//        clienteDAO = new ClienteDAO();
//        clienteDAO = new ClienteDAOMock();
        this.clienteDAO = clienteDAO;
    }

    public String salvar() {
        clienteDAO.salvar();
        return "Sucesso";
    }

}
