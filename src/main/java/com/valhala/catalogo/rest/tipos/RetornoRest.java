package com.valhala.catalogo.rest.tipos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RetornoRest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String mensagem;
	private Object retorno;
	
	public RetornoRest() {
		// TODO Auto-generated constructor stub
	}

	public RetornoRest(String mensagem, Object retorno) {
		super();
		this.mensagem = mensagem;
		this.retorno = retorno;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
