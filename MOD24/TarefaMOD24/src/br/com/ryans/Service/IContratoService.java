package br.com.ryans.Service;

import br.com.ryans.DAO.ContratoDAOMock;

public interface IContratoService {

    int buscarContrato(int id);

    boolean excluirContrato(int id);

    boolean atualizarContrato(int id);
}
