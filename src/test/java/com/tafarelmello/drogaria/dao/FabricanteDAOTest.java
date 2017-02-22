package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	public void salvar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();

		fabricante.setDescricao("ddd");

		dao.salvar(fabricante);
	}

	@Test
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = new ArrayList<>();

		fabricantes = dao.listar();

		if (fabricantes != null) {
			System.out.println(fabricantes);
		} else {
			System.out.println("Nenhum Fabricante encontrado");
		}
	}

	@Test
	public void buscar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();

		fabricante = dao.buscar(1L);

		if (fabricante != null) {
			System.out.println(fabricante);
		} else {
			System.out.println("Nenhum Fabricante encontrado");
		}
	}

	@Test
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();

		fabricante = dao.buscar(3L);

		if (fabricante != null) {
			dao.excluir(fabricante);
			System.out.println(fabricante);
		} else {
			System.out.println("Nenhum Fabricante encontrado");
		}
	}

	@Test
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();

		fabricante = dao.buscar(4L);

		if (fabricante != null) {
			System.out.println(fabricante);
			
			fabricante.setDescricao("Mudouuu");
			dao.editar(fabricante);
			
			System.out.println(fabricante);
		} else {
			System.out.println("Nenhum Fabricante encontrado");
		}
	}
}
