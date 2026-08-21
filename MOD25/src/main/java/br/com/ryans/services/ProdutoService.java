package br.com.ryans.services;

import br.com.ryans.dao.IProdutoDAO;
import br.com.ryans.services.generic.IGenericService;
import br.com.ryans.domain.Produto;


public class ProdutoService extends GenericService<Produto, String> implements IProdutoService{
	
	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
