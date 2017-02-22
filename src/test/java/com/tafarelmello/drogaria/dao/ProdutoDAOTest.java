package com.tafarelmello.drogaria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Fabricante;
import com.tafarelmello.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();

		fabricante = fabricanteDAO.buscar(1L);

		if (fabricante != null) {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = new Produto();

			produto.setDescricao("remedio pra dor");
			produto.setFabricante(fabricante);
			produto.setPreco(new BigDecimal("20.20"));
			produto.setQuatidade(new Short("3"));

			produtoDAO.salvar(produto);

			System.out.println("Produto salvo com sucesso.");
		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void listar() {
		List<Produto> produtos = new ArrayList<>();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		produtos = produtoDAO.listar();
		if (produtos != null) {
			System.out.println(produtos);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void buscar() {
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		produto = produtoDAO.buscar(1L);
		if (produto != null) {
			System.out.println(produto);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void excluir() {
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		produto = produtoDAO.buscar(4L);
		
		if(produto != null){
			produtoDAO.excluir(produto);
			
			System.out.println("Produto Excluido com sucesso.");
		}else{
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void editar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = new Produto();

		fabricante = fabricanteDAO.buscar(2L);

		if (fabricante != null) {
			
			produto = produtoDAO.buscar(3L);
			
			if(produto != null){
				produto.setDescricao("sdsdsdd");
				produto.setFabricante(fabricante);
				produto.setPreco(new BigDecimal("45.20"));
				produto.setQuatidade(new Short("2"));

				produtoDAO.editar(produto);

				System.out.println("Produto editado com sucesso.");
			}else{
				System.out.println("produto não encontrado");
			}
			
		} else {
			System.out.println("fabricante não encontrado.");
		}
	}
}
