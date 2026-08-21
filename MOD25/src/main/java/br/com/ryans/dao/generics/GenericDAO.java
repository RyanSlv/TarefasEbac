/**
 * 
 */
package br.com.ryans.dao.generics;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import anotacao.TipoChave;
import br.com.ryans.exceptions.TipoChaveNaoEncontradaException;
import br.com.ryans.dao.Persistente;

/**
 * 
 */
public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {
	
//protected Map<Class, Map<Long, T>> map = new HashMap<>();
	
	private final SingletonMap singletonMap;
	
	private abstract Class<T> getTipoClasse();
	
	public abstract void atualizarDados(T entity, T entityCadastrado);
	
	public GenericDAO() {
		this.singletonMap = SingletonMap.getInstance();
		
	}
	
	@Override
	public E getChave(T ebtity) throws TipoChaveNaoEncontradaException {
		Field[] fields = entity.getClass().getDeclaredFields();
		E returnValue = null;
		for (Field field : fields) {
			if(field.isAnnotationPresent(TipoChave.class)) {
				TipoChave tipochave = field.getAnnotation(TipoChave.class);
				String nomeMetodo = tipoChave.value();
				try {
					Method method = entity.getClass().getMethod(nomeMetodo);
					returnValue = (E) method.invoke(entity);
					return returnValue;
				} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
					throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
					
				}
			}
		}
		
		if (returnValue == null) {
			String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
			System.out.println("** ERRO **" + msg);
			throw new TipoChaveNaoEncontradaException(msg);
		}
		return null;
	}
	
	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
//		Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
		Map<E, T> mapaInterno = getMapa();
		E chave = getChave(entity);
		if (mapaInterno.containsKey(chave)) {
			return false;
		}
		
		mapaInterno.put(chave, entity);
		return true;
		
	}
	
	private Map<E, T> getMapa() {
		return SingletonMap.getInstance().getMap(getTipoClasse());
		
	}
	
	@Override 
	public void excluir(E valor) {
//		Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
		Map<E, T> mapaInterno = getMapa();
		T objetoCadastrado = mapaInterno.get(valor);
		if (objetoCadastrado != null) {
			mapaInterno.remove(valor, objetoCadastrado);
		}
	} 
	
	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException {
		Map<E, T>  mapaInterno = getMapa();
		E chave = getChave(entity);
		T objetoCadastrado = mapaInterno.get(chave);
		if (objetoCadastrado != null) {
			atualizarDados(entity, objetoCadastrado);
		}
		
		@Override 
		public T consultar(E valor) {
//			Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
			Map<E, T> mapaInterno = getMapa();
			return mapaInterno.get(valor);
		}
		
		@Override 
		public Collection<T> buscarTodos() {
			Map<E, T> mapaInterno = getMapa();
			return mapaInterno.values();
		}
		
	}
	
}
