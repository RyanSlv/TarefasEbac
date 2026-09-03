package br.com.ryans.dao;

import br.com.ryans.domain.Acessorio;

public interface IAcessorioDAO {

	Acessorio cadastrar(Acessorio acessorio);

	void deletar(Acessorio acessorio);

	void atualizar(Acessorio acessorio);

	Acessorio buscarPorId(Long id);

}
