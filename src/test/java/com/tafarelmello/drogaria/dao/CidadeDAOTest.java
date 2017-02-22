package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Cidade;
import com.tafarelmello.drogaria.domain.Estado;

public class CidadeDAOTest {

	@Test
	public void salvar() {
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
	public void listar() {
		List<Cidade> cidades = new ArrayList<>();
		CidadeDAO cidadeDAO = new CidadeDAO();

		cidades = cidadeDAO.listar();
		if (cidades != null) {
			System.out.println(cidades);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void buscar() {
		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = new CidadeDAO();

		cidade = cidadeDAO.buscar(5L);

		if (cidade != null) {
			System.out.println(cidade);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void excluir() {
		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = new CidadeDAO();

		cidade = cidadeDAO.buscar(4L);

		if (cidade != null) {
			cidadeDAO.excluir(cidade);

			System.out.println("Cidade removida. " + cidade);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void editar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = new Estado();

		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = new CidadeDAO();

		cidade = cidadeDAO.buscar(5L);
		
		System.out.println("cidade a ser editada = " + cidade);
		
		if (cidade != null) {

			cidade.setNome("aaaa");
			estado = estadoDAO.buscar(3L);			
			
			if (estado != null) {
				cidade.setEstado(estado);
				
				cidadeDAO.editar(cidade);
				
				System.out.println("APOS EDIÇÃO = " + cidade);
			} else {
				System.out.println("Nenhum registro encontrado.");
			}

		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}
}
