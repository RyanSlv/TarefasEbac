package br.com.ryans.vendas.online.usecase;

import org.springframework.stereotype.Service;

import br.com.ryans.vendas.online.domain.Cliente;
import br.com.ryans.vendas.online.repository.IClienteRepository;
import jakarta.validation.Valid;

@Service
public class CadastroCliente {

	private final IClienteRepository clienteRepository;
	
	public CadastroCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrar(@Valid Cliente cliente) {
		return clienteRepository.insert(cliente);
	}
	
	public Cliente atualizar(@Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void remover(String id) {
		clienteRepository.deleteById(id);
	}
}
