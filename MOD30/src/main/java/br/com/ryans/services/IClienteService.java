package br.com.ryans.services;

import br.com.ryans.domain.Cliente;
import br.com.ryans.exceptions.DAOException;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;
import br.com.ryans.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
