/**
 * 
 */
package br.com.ryans.dao;

import br.com.ryans.dao.generics.GenericDAO;
import br.com.ryans.domain.Venda;


/**
 * 
 */
public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO{
	
	@Override
	public Class<Venda> getTipoClasse() {
		return Venda.class;
		
	}
	
	@Override
	public void atualizarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());
	}
	
	
	@Override
	public void excluir(String valor) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
		
	}
	
	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
		venda.setStatus(Status.CONCLUIDA);
		super.alterar(venda);
	}

}
