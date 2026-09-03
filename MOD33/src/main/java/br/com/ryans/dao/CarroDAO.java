package br.com.ryans.dao;

import br.com.ryans.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarroDAO implements ICarroDAO {
	
	@Override
	public Carro cadastrar(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return carro;
	}
	
	@Override
	public Carro buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Carro carro = entityManager.find(Carro.class, id);
		
		entityManager.close();
		entityManagerFactory.close();
		
		return carro;
		
	}
	
	@Override
	public void atualizar(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.merge(carro);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

	@Override
	public void deletar(Carro carro) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(carro) ? carro : entityManager.merge(carro));
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
