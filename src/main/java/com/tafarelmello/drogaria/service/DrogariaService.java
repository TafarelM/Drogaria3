package com.tafarelmello.drogaria.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8080/Drogaria/rest/[Nome]

@Path("drogaria")
public class DrogariaService {
	
	@GET
	public String exibir(){
		
		return "Curso de Java.";
	}
}
