package br.com.ryans.Service;

import br.com.ryans.DAO.ContratoDAOMock;

public interface IContratoService {
    String salvar();

    int buscarContrato(int id);

    boolean excluirContrato(int id);

    boolean atualizarContrato(ContratoDAOMock contrato);
}
