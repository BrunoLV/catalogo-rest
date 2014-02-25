package com.valhala.catalogo.rest.tipos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Erro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeException;
	private String mensagemException;
	
	public Erro() {
		// TODO Auto-generated constructor stub
	}
	
	public Erro(String nomeException, String mensagemException) {
		super();
		this.nomeException = nomeException;
		this.mensagemException = mensagemException;
	}

	public String getNomeException() {
		return nomeException;
	}

	public void setNomeException(String nomeException) {
		this.nomeException = nomeException;
	}

	public String getMensagemException() {
		return mensagemException;
	}

	public void setMensagemException(String mensagemException) {
		this.mensagemException = mensagemException;
	}	

} // fim da classe Erro