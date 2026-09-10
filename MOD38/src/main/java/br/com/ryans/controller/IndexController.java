package br.com.ryans.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String redirectedCliente() {
		return "/cliente/list.xhtml?faces-redirect=true";
	}
}
