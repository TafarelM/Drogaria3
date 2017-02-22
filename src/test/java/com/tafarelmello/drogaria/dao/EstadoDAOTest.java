package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Estado;

public class EstadoDAOTest {

	@Test
	public void salvar() {
		Estado estado = new Estado();

		estado.setNome("tttt");
		estado.setSigla("mm");

		EstadoDAO dao = new EstadoDAO();
		dao.salvar(estado);

	}

	@Test
	public void listar() {
		EstadoDAO dao = new EstadoDAO();
		List<Estado> estados = new ArrayList<>();

		estados = dao.listar();

		System.out.println(estados);
	}

	@Test
	public void buscar() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = new Estado();

		estado = dao.buscar(2L);

		if (estado != null) {
			System.out.println(estado);
		} else {

		}

	}

	@Test
	public void excluir() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = new Estado();

		estado = dao.buscar(7L);
		if (estado != null) {
			dao.excluir(estado);
			System.out.println(estado + " estado removido com sucesso.");
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void editar() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = new Estado();

		estado = dao.buscar(3L);

		if (estado != null) {
			System.out.println(estado);
			
			estado.setNome("mmmmr");
			estado.setSigla("MM");
			dao.editar(estado);
			
			System.out.println(estado + " estado editado com sucesso.");
		}else{
			System.out.println("Nenhum registro encontrado.");
		}

	}

}
