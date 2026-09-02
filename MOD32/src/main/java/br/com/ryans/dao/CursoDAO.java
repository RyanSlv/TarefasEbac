package br.com.ryans.dao;

import java.util.List;

import br.com.ryans.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CursoDAO implements ICursoDAO{

	@Override
	public Curso cadastrar(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return curso;
	}
	
	@Override
	public Curso buscarPorCodigo(String codigo) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT cur FROM Curso cur ");
		sb.append("WHERE cur.codigo = :codigo");
		
		TypedQuery<Curso> query = entityManager.createQuery(sb.toString(), Curso.class);
		query.setParameter("codigo", codigo);
		
		Curso curso = query.getSingleResult();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return curso;
	}
	
	@Override
	public List<Curso> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT cur FROM Curso cur");
		
		TypedQuery<Curso> query = entityManager.createQuery(sb.toString(), Curso.class);
		
		List<Curso> list = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}
	
	@Override
	public Curso alterar(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		curso = entityManager.merge(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return curso;
	}
	
	@Override
	public void excluir(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		curso = entityManager.merge(curso);
		entityManager.remove(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
