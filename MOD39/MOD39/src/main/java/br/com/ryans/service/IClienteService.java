package br.com.ryans.service;

import java.util.Collection;

import br.com.ryans.domain.Cliente;

public interface IClienteService {

	Boolean cadastrar(Cliente cliente);
	
	void excluir(Cliente cliente);
	
	Cliente alterar(Cliente cliente);
	
	Cliente consultar(Long cpf);
	
	Collection<Cliente> buscarTodos();
}
