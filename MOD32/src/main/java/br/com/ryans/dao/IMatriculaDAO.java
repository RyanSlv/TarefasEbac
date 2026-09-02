package br.com.ryans.dao;

import java.util.List;

import br.com.ryans.domain.Curso;
import br.com.ryans.domain.Matricula;

public interface IMatriculaDAO {

	Matricula cadastrar(Matricula mat);

	void excluir(Matricula matricula);

	Matricula alterar(Matricula matricula);

	List<Matricula> buscarTodos();

	Matricula buscarPorCodigoCurso(String codigoCurso);

	Matricula buscarPorCurso(Curso curso);

}
