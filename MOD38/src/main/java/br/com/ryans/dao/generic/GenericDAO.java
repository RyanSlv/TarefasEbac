package br.com.ryans.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.ryans.domain.Persistente;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T, E> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	private Class<T> persistenteClass;
	
	public GenericDAO(Class<T> persistenteClass) {
		this.persistenteClass = persistenteClass;
	}
	
	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			entityManager.persist(entity);
			return true;
		}	catch(Exception e) {
			throw new DAOException("ERRO AO CADASTRAR OBJETO", e);
		}
	}
	
	@Override
	public void excluir(T entity) throws DAOException {
		try {
			T entityAtual = entityManager.merge(entity);
			entityManager.remove(entityAtual);
		}	catch (Exception e) {
			throw new DAOException("ERRO EXCLUINDO OBJETO",  e);
		}
	}
	
	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			return entityManager.merge(entity);
		}	catch (Exception e) {
			throw new DAOException("ERRO ALTERANDO OBJETO", e);
		}
	}
	
	@Override
	public T consultar(E valor) throws DAOException {
		try {
			return entityManager.find(persistenteClass, valor);
		}	catch (Exception e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO", e);
		}
	}
	
	@Override
	public Collection<T> buscarTodos() throws DAOException {
		try {
			String jpql = "SELECT obj FROM " + persistenteClass.getSimpleName() + " obj";
			TypedQuery<T> query = entityManager.createQuery(jpql, persistenteClass);
			return query.getResultList();
		}	catch (Exception e) {
			throw new DAOException("ERRO BUSCANDO TODOS OS OBJETOS", e);
		}
	}
}
