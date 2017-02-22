package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Cidade;
import com.tafarelmello.drogaria.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = new Estado();
		estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		cidade.setNome("ssss");
		cidade.setEstado(estado);
		
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	public void listar(){		
		List<Cidade> cidades = new ArrayList<>();
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		if(cidades  != null){
			cidades = cidadeDAO.listar();
			
			System.out.println(cidades);
		}
		
	}
	
	@Test
	public void buscar(){
		
	}
}
