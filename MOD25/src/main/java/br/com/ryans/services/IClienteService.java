/**
 * 
 */
package br.com.ryans.services;


import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;
import br.com.ryans.domain.Cliente;

/**
 * 
 */
public interface IClienteService {
	
	Boolean cadastraar(Cliente cliente) throws TipoChaveNaoEncontradaException;
	
	Cliente buscarPorCpf(Long cpf);
	
	void excluir(Long cpf);
	
	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
