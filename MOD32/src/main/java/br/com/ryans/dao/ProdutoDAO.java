package br.com.ryans.dao;

import java.util.List;

import br.com.ryans.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Produto cadastrar(Produto produto) {
	
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("ExemploJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();
	entityManager.persist(produto);
	entityManager.getTransaction().commit();

	
	entityManager.close();
	entityManagerFactory.close();
	
	return produto;

	}
	
	@Override
	public Produto buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Produto produto = entityManager.find(Produto.class, id);
		
		entityManager.close();
		entityManagerFactory.close();
		
		return produto;
	}
	
	@Override
	public List<Produto> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT prod FROM Produto prod");
		
		TypedQuery<Produto> query = entityManager.createQuery(sb.toString(), Produto.class);
		
		List<Produto> list = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}
	
	@Override
	public void excluir(Produto produto) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		produto = entityManager.merge(produto);
		entityManager.remove(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
		
	}
}
