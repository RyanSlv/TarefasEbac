package br.com.ryans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.ryans.dao.IProdutoDAO;
import br.com.ryans.dao.ProdutoDAO;
import br.com.ryans.domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	@Before
	public void setUp() {
		produtoDAO = new ProdutoDAO();
	}
	
	@After
	public void tearDown() {
		List<Produto> produtos = produtoDAO.buscarTodos();
		
		for (Produto produto : produtos) {
			produtoDAO.excluir(produto);
		}
	}
	
	@Test 
	public void testCadastrarProduto() {
		Produto produto = new Produto();
		
		produto.setNome("Produto Teste");
		produto.setPreco(100.0);
		
		Produto produtoCadastrado = produtoDAO.cadastrar(produto);
		assertNotNull(produtoCadastrado.getId());
		assertEquals("Produto Teste", produtoCadastrado.getNome());
		assertEquals(100.0, produtoCadastrado.getPreco(), 0.001);
		
	}
	
	@Test
	public void testBuscarPorId() {
		Produto produto = new Produto();
		
		produto.setNome("Produto Busca");
		produto.setPreco(200.0);
		
		produtoDAO.cadastrar(produto);
		
		Produto produtoRecuperado = produtoDAO.buscarPorId(produto.getId());
		assertNotNull(produtoRecuperado);
		assertEquals("Produto Busca", produtoRecuperado.getId());
		assertEquals(200.0, produtoRecuperado.getPreco(), 0.001);
	}
}
