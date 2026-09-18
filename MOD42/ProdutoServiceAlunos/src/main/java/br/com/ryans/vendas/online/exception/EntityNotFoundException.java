package br.com.ryans.vendas.online.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> clazz, String campo, Object valor) {
        super(clazz.getSimpleName()
                + " não encontrado com "
                + campo
                + " = "
                + valor);
    }
}