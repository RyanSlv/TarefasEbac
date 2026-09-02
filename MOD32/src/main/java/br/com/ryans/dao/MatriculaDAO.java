package br.com.ryans.dao;

import java.util.List;

import br.com.ryans.domain.Curso;
import br.com.ryans.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MatriculaDAO implements IMatriculaDAO {

	@Override
	public Matricula cadastrar(Matricula mat) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(mat);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return mat;
	}
	
	@Override 
	public Matricula buscarPorCodigoCurso(String codigoCurso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mat FROM Matricula mat ");
		sb.append("INNER JOIN Curso cur on cur = mat.curso ");
		sb.append("WHERE cur.codigo = :codigoCurso");
		
		entityManager.getTransaction().begin();
		TypedQuery<Matricula> query = entityManager.createQuery(sb.toString(), Matricula.class);
		query.setParameter("codigoCurso", codigoCurso);
		Matricula matricula = query.getSingleResult();
		
		entityManager.close();
		entityManagerFactory.close();
		return matricula;
		
	}
	
	@Override
	public Matricula buscarPorCurso(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mat FROM MATRICULA mat");
		sb.append("INNER JOIN Curso cur on cur = mat.curso ");
		sb.append("WHERE cur = :curso");
		
		entityManager.getTransaction().begin();
		TypedQuery<Matricula> query = entityManager.createQuery(sb.toString(), Matricula.class);
		query.setParameter("curso", curso);
		Matricula matricula = query.getSingleResult();
		
		entityManager.close();
		entityManagerFactory.close();
		return matricula;
	}
	
	@Override
	public List<Matricula> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mat FROM Matricula mat");
		
		TypedQuery<Matricula> query = entityManager.createQuery(sb.toString(), Matricula.class);
		List<Matricula> list = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}
	
	@Override
	public Matricula alterar(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		matricula = entityManager.merge(matricula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return matricula;
	}
	
	@Override
	public void excluir(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		matricula = entityManager.merge(matricula);
		entityManager.remove(matricula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
