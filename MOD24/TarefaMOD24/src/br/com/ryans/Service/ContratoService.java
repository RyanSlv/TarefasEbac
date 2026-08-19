package br.com.ryans.Service;

import br.com.ryans.DAO.ContratoDAOMock;
import br.com.ryans.DAO.IContratoDAO;

public class ContratoService implements IContratoService {

    private final IContratoDAO contratoDAO;

    public ContratoService(IContratoDAO dao) {
        this.contratoDAO = dao;
    }

    public ContratoService() {
        this.contratoDAO = new ContratoDAOMock();

    }

    @Override
    public String salvar() {
        contratoDAO.salvar();
        return "Sucesso";
    }

    @Override
    public int buscarContrato(int id) {
        return id;

    }

    @Override
    public boolean atualizarContrato(ContratoDAOMock contrato) {
        return true;
    }
}
