/**
 * 
 */
package br.com.ryans.dao.generics;

import br.com.ryans.dao.Persistente;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class SingletonMap {
	
	private static SingletonMap singletonMap;
	
	protected Map<Class<?>, Map<?, ?>> map;
	
	private SingletonMap() {
		map = new HashMap<>();
	}
	
	public static SingletonMap getInstance() {
		if (singletonMap == null) {
			singletonMap = new SingletonMap();
			
		}
		return singletonMap;
		
	}
	
	public <E extends Serializable, T extends Persistente> Map<E, T> getMap(Class<T> clazz) {
		Map<E, T> classMap = (Map<E, T>) map.get(clazz);
		if (classMap == null) {
			classMap = new HashMap<>();
			map.put(clazz, classMap);
		}
		return classMap;
	}

}
