package br.com.ryans.dao;

import java.util.List;

import br.com.ryans.domain.Curso;

public interface ICursoDAO {

	
	public Curso cadastrar(Curso curso);

	void excluir(Curso curso);

	List<Curso> buscarTodos();

	Curso alterar(Curso curso);

	Curso buscarPorCodigo(String codigo);
}
