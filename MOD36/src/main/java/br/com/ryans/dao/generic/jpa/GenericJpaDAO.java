package br.com.ryans.dao.generic.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.com.ryans.domain.jpa.Persistente;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.MaisDeUmRegistroException;
import br.com.ryans.exceptions.TableException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

public class GenericJpaDAO<T extends Persistente,E extends Serializable> implements IGenericJpaDAO<T,E> {

	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	private Class<T> persistenteClass;
	private String persistenceUnitName;

	public GenericJpaDAO(Class<T> persistenteClass) {
		this(persistenteClass,"Postgre1");
	}

	public GenericJpaDAO(Class<T> persistenteClass,String persistenceUnitName) {
		this.persistenteClass=persistenteClass;
		this.persistenceUnitName=persistenceUnitName;
	}

	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException,DAOException {
		openConnection();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public void excluir(T entity) throws DAOException {
		openConnection();
		entity=entityManager.merge(entity);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		closeConnection();
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException,DAOException {
		openConnection();
		entity=entityManager.merge(entity);
		entityManager.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public T consultar(E valor) throws MaisDeUmRegistroException,TableException,DAOException {
		openConnection();
		T entity=entityManager.find(this.persistenteClass,valor);
		entityManager.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		openConnection();
		List<T> list=entityManager.createQuery(getSelectSql(),this.persistenteClass).getResultList();
		entityManager.getTransaction().commit();
		closeConnection();
		return list;
	}

	protected void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnitName);
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	protected void closeConnection() {
		if(entityManager!=null&&entityManager.isOpen()) {
			entityManager.close();
		}
		if(entityManagerFactory!=null&&entityManagerFactory.isOpen()) {
			entityManagerFactory.close();
		}
	}

	private String getSelectSql() {
		return "SELECT obj FROM "+this.persistenteClass.getSimpleName()+" obj";
	}
}