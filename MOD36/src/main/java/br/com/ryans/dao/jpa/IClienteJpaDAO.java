package br.com.ryans.dao.jpa;

import br.com.ryans.dao.generic.jpa.IGenericJpaDAO;
import br.com.ryans.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJpaDAO<T,Long>{

}