package br.com.ryans.dao;

import br.com.ryans.domain.Marca;

public interface IMarcaDAO {

	Marca buscarPorId(Long id);

	Marca cadastrar(Marca marca);

	void deletar(Marca marca);

	void atualizar(Marca marca);

}
