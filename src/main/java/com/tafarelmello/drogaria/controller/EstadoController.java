package com.tafarelmello.drogaria.controller;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

@ManagedBean
public class EstadoController {
	
	public void salvar(){
		Messages.addGlobalInfo("TEST");
	}
}
