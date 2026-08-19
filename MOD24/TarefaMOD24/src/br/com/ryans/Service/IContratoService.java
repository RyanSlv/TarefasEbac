package br.com.ryans.Service;

public interface IContratoService {
    String salvar();

    int buscarContrato(int id);

    boolean excluirContrato(int id);

    boolean atualizarContrato(int id);
}
