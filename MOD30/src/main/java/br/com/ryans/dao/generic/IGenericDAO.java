package br.com.ryans.dao.generic;

import br.com.ryans.dao.Persistente;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.MaisDeUmRegistroException;
import br.com.ryans.exceptions.TableException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public void excluir(E valor) throws DAOException;

    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> buscarTodos() throws DAOException;
}