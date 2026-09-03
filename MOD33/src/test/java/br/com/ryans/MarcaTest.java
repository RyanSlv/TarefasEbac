package br.com.ryans;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ryans.dao.IMarcaDAO;
import br.com.ryans.dao.MarcaDAO;
import br.com.ryans.domain.Marca;

public class MarcaTest {

	private IMarcaDAO marcaDAO;
	
	public MarcaTest() {
		marcaDAO = new MarcaDAO();
		
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setNome("Ford");
		marca = marcaDAO.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());

	}
}
