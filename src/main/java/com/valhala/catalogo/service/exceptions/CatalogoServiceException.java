package com.valhala.catalogo.service.exceptions;

public class CatalogoServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CatalogoServiceException() {
		// TODO Auto-generated constructor stub
	}
	
	public CatalogoServiceException(String message) {
		super(message);
	}
	
	public CatalogoServiceException(Throwable cause) {
		super(cause);
	}
	
	public CatalogoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}