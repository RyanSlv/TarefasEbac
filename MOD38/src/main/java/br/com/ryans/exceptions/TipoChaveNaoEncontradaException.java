package br.com.ryans.exceptions;


public class TipoChaveNaoEncontradaException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public TipoChaveNaoEncontradaException(String msg) {
		super(msg);
	}
}
