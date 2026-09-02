package br.com.ryans.dao;

import java.util.List;

import br.com.ryans.domain.Produto;

public interface IProdutoDAO {

	Produto cadastrar(Produto produto);

	Produto buscarPorId(Long id);

	void excluir(Produto produto);

	List<Produto> buscarTodos();

}
