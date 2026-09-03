package br.com.ryans.dao;

import br.com.ryans.domain.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessorioDAO implements IAcessorioDAO{

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
		
	}
	
	@Override
	public Acessorio buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		Acessorio acessorio = entityManager.find(Acessorio.class, id);
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}
	
	@Override
	public void atualizar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.merge(acessorio);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Override
	public void deletar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(acessorio) ? acessorio : entityManager.merge(acessorio));
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
