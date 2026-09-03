package br.com.ryans;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ryans.dao.CarroDAO;
import br.com.ryans.dao.ICarroDAO;
import br.com.ryans.dao.IMarcaDAO;
import br.com.ryans.dao.MarcaDAO;
import br.com.ryans.domain.Carro;
import br.com.ryans.domain.Marca;

public class CarroTest {

	private ICarroDAO carroDAO;
	private IMarcaDAO marcaDAO;
	
	public CarroTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setNome("Ford");
		marca = marcaDAO.cadastrar(marca);
		
		Carro carro = new Carro();
		carro.setModelo("Ka");
		carro.setMarca(marca);
		carro = carroDAO.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
}
