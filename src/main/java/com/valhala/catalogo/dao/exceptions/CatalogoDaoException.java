package com.valhala.catalogo.dao.exceptions;

public class CatalogoDaoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CatalogoDaoException() {
		// TODO Auto-generated constructor stub
	}
	
	public CatalogoDaoException(String message) {
		super(message);
	}
	
	public CatalogoDaoException(Throwable cause) {
		super(cause);
	}
	
	public CatalogoDaoException(String message, Throwable cause) {
		super(message, cause);
	}

}