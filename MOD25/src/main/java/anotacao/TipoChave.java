/**
 * 
 */
package anotacao;

import java.lang.annotation.*;


/**
 * 
 */
public class TipoChave {
	
	@Documented
	@target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TipoChave {
		
		String value();
	}
	

}
