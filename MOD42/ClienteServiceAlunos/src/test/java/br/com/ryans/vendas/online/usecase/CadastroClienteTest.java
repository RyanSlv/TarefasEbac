package br.com.ryans.vendas.online.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.ryans.vendas.online.domain.Cliente;
import br.com.ryans.vendas.online.repository.IClienteRepository;
import br.com.ryans.vendas.online.usecase.CadastroCliente;

class CadastroClienteTest {

	@Test
	void deveCadastrar() {
	IClienteRepository repository = Mockito.mock(IClienteRepository.class);
	
	Cliente cliente = Cliente.builder()
			.nome("Ryan")
			.cpf(12345678901L)
			.tel(1199999999L)
			.email("ryan@email.com")
			.end("Rua Teste")
			.numero(100)
			.cidade("São Paulo")
			.estado("SP")
			.build();
	
	when(repository.insert(cliente)).thenReturn(cliente);
	
	CadastroCliente cadastroCliente = new CadastroCliente(repository);
	
	Cliente resultado = cadastroCliente.cadastrar(cliente);
	
	assertEquals(cliente.getCpf(), resultado.getCpf());
	}
}