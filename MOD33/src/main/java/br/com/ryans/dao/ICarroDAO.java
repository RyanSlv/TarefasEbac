package br.com.ryans.dao;

import br.com.ryans.domain.Carro;

public interface ICarroDAO {

	Carro cadastrar(Carro carro);

	Carro buscarPorId(Long id);

	void deletar(Carro carro);

	void atualizar(Carro carro);

}
