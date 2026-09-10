package br.com.ryans.services.generic;

import java.io.Serializable;
import java.util.Collection;

import javax.transaction.Transactional;

import br.com.ryans.dao.generic.IGenericDAO;
import br.com.ryans.domain.Persistente;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericService<T extends Persistente, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {

        return dao.cadastrar(entity);
    }

    @Override
    @Transactional
    public void excluir(T entity) throws DAOException {

        dao.excluir(entity);
    }

    @Override
    @Transactional
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {

        return dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws DAOException {

        return dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {

        return dao.buscarTodos();
    }
}