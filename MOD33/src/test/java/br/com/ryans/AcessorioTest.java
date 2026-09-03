package br.com.ryans;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ryans.dao.AcessorioDAO;
import br.com.ryans.dao.CarroDAO;
import br.com.ryans.dao.IAcessorioDAO;
import br.com.ryans.dao.ICarroDAO;
import br.com.ryans.dao.IMarcaDAO;
import br.com.ryans.dao.MarcaDAO;
import br.com.ryans.domain.Acessorio;
import br.com.ryans.domain.Carro;
import br.com.ryans.domain.Marca;

public class AcessorioTest {

	private IAcessorioDAO acessorioDAO;
	private ICarroDAO carroDAO;
	private IMarcaDAO marcaDAO;
	
	public AcessorioTest() {
		acessorioDAO = new AcessorioDAO();
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
		
		Acessorio acessorio = new Acessorio();
		acessorio.setNome("Gps");
		acessorio.setCarro(carro);
		acessorio = acessorioDAO.cadastrar(acessorio);
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
	}
}
