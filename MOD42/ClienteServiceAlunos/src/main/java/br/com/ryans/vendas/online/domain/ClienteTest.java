package br.com.ryans.vendas.online.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class ClienteTest {

	@Test
	void deveCriarClienteComDadosCorretos() {
		
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
		
		assertEquals("Ryan", cliente.getNome());
		assertEquals(Long.valueOf(12345678901L), cliente.getCpf());
        assertEquals("ryan@email.com", cliente.getEmail());
	}
}
