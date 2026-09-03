package br.com.ryans.dao;

import br.com.ryans.domain.Carro;
import br.com.ryans.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO {

	
	@Override 
	public Marca cadastrar(Marca marca) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(marca);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return marca;
	}
	
	@Override
	public Marca buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Marca marca = entityManager.find(Marca.class, id);
		
		entityManager.close();
		entityManagerFactory.close();
		
		return marca;
	}
	
	@Override
	public void atualizar(Marca marca) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	entityManager.getTransaction().begin();
	entityManager.merge(marca);
	entityManager.getTransaction().commit();
	
	entityManager.close();
	entityManagerFactory.close();
	
	}
	
	@Override
	public void deletar(Marca marca) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(marca) ? marca : entityManager.merge(marca));
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
