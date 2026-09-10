package br.com.ryans.exceptions;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DAOException(String msg, Exception e) {
		super(msg, e);
	}
	
	public DAOException(String msg) {
		super(msg);
	}
}
