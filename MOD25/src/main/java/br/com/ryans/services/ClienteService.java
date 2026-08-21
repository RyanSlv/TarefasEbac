/**
 * 
 */
package br.com.ryans.services;


import br.com.ryans.IClienteDAO;
import br.com.ryans.domain.Cliente;
import br.com.ryans.services.generic.GenericService;

/**
 * 
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
//	private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
//		this.clienteDAO = clienteDAO
		
	}
	
//	@Override 
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//		
//	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		return this.dao.consultar(cpf);
		
	}
	
//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//	
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}
	
	
}
