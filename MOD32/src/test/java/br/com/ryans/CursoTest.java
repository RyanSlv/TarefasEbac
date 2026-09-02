package br.com.ryans;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ryans.dao.CursoDAO;
import br.com.ryans.dao.ICursoDAO;
import br.com.ryans.domain.Curso;

public class CursoTest {
	
	private ICursoDAO cursoDAO;
	
	public CursoTest() {
		cursoDAO = new CursoDAO();
	}
	
	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A!");
		curso.setDescricao("Curso Teste");
		curso.setNome("Curso de Java Backend");
		curso = cursoDAO.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
	}
} 