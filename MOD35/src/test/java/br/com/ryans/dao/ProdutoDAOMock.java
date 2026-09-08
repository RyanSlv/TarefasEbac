package br.com.ryans.dao;

import java.util.Collection;

import br.com.ryans.domain.Produto;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOMock implements IProdutoDAO {

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		return true;
	}

	@Override
	public void excluir(String valor) {
		
	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
		
	}

	@Override
	public Produto consultar(String valor) {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		return null;
	}

}
