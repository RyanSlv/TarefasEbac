/**
 * 
 */
package br.com.ryans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.ryans.dao.generic.jdbc.dao.IProdutoDAO;
import br.com.ryans.dao.generic.jdbc.dao.ProdutoDAO;
import br.com.ryans.domain.Produto;

/**
 * 
 */
public class ProdutoTest {

	private IProdutoDAO produtoDAO; 
	
	@Test
	public void cadastrarTest() throws Exception {
		
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setPreco(100.00);
		produto.setQuantidade(10);
		
		Integer countCad = produtoDAO.cadastrar(produto);
		
		assertTrue(countCad == 1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		
		assertNotNull(list);
		
		Produto produtoBD = list.get(0);
		
		assertNotNull(produtoBD);
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getPreco(), produtoBD.getPreco(), 0.001);
		assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTest() throws Exception {
		
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setPreco(100.00);
		produto.setQuantidade(10);
		
		Integer countCad = produtoDAO.cadastrar(produto);
		
		assertTrue(countCad == 1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		
		assertNotNull(list);
		
		Produto produtoBD = list.get(0);
		
		Produto produtoBusca = produtoDAO.buscar(produtoBD.getId());
		
		assertNotNull(produtoBusca);
		assertEquals(produto.getNome(), produtoBusca.getNome());
		assertEquals(produto.getPreco(), produtoBusca.getPreco(), 0.001);
		assertEquals(produto.getQuantidade(), produtoBusca.getQuantidade());
		
		Integer countDel = produtoDAO.excluir(produtoBusca);
		
		assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest() throws Exception {
		
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setPreco(100.00);
		produto.setQuantidade(10);
		
		Integer countCad = produtoDAO.cadastrar(produto);
		
		assertTrue(countCad == 1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		
		assertNotNull(list);
		
		Produto produtoBD = list.get(0);
		
		assertNotNull(produtoBD);
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		
		assertTrue(countDel == 1);
		
		Produto produtoExcluido = produtoDAO.buscar(produtoBD.getId());
		
		assertNull(produtoExcluido);
	}
	
	@Test 
	public void buscarTodosTest() throws Exception {
		
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setPreco(100.00);
		produto.setQuantidade(10);
		
		Integer countCad = produtoDAO.cadastrar(produto);
		
		assertTrue(countCad == 1);
		
		Produto produtos = new Produto();
		produtos.setNome("Produto Teste 2");
		produtos.setPreco(200.00);
		produtos.setQuantidade(20);
		
		Integer countCad2 = produtoDAO.cadastrar(produtos);
		
		assertTrue(countCad2 == 1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int countDel = 0;
		
		for (Produto prod : list) {
			produtoDAO.excluir(prod);
			countDel++;
		}

		assertEquals(list.size(), countDel);
		
		list = produtoDAO.buscarTodos();
		
		assertEquals(list.size(), 0);
		
		}

		@Test
		public void atualizarTest() throws Exception {
			
			produtoDAO = new ProdutoDAO();
			
			Produto produto = new Produto();
			produto.setNome("Produto Teste");
			produto.setPreco(100.00);
			produto.setQuantidade(10);
			
			Integer countCad = produtoDAO.cadastrar(produto);
			
			assertTrue(countCad == 1);
			
			List<Produto> list = produtoDAO.buscarTodos();
			
			assertNotNull(list);
			
			Produto produtoBD = list.get(0);
			
			assertNotNull(produtoBD);
			assertEquals(produto.getNome(), produtoBD.getNome());
			assertEquals(produto.getPreco(), produtoBD.getPreco(), 0.001);
			assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());		
			
			produtoBD.setNome("Outro Produto");
			produtoBD.setPreco(200.00);
			produtoBD.setQuantidade(20);
			
			Integer countUpdate = produtoDAO.atualizar(produtoBD);
			
			assertTrue(countUpdate == 1);
			
			Produto produtoBD2 = produtoDAO.buscar(produtoBD.getId());
			
			assertNotNull(produtoBD2);
			assertEquals(produtoBD.getNome(), produtoBD2.getNome());
			assertEquals(produtoBD.getPreco(), produtoBD2.getPreco(), 0.001);
			assertEquals(produtoBD.getQuantidade(), produtoBD2.getQuantidade());		
			
			list = produtoDAO.buscarTodos();
			
			for (Produto prod : list) {
			
			produtoDAO.excluir(prod);
			}

		}
}
