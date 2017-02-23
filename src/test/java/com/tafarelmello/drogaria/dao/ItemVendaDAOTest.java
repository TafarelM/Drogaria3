package com.tafarelmello.drogaria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.ItemVenda;
import com.tafarelmello.drogaria.domain.Produto;
import com.tafarelmello.drogaria.domain.Venda;

public class ItemVendaDAOTest {

	@Test
	public void salvar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = new ItemVenda();

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = new Produto();

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = new Venda();

		produto = produtoDAO.buscar(1L);
		venda = vendaDAO.buscar(1L);

		if (produto != null && venda != null) {
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("3"));
			itemVenda.setValorParcial(new BigDecimal("223"));
			itemVenda.setVenda(venda);

			itemVendaDAO.salvar(itemVenda);

			System.out.println("Item da Venda salvo com sucesso.");
		} else {
			System.out.println("Erro ao salvar Item da Venda.");
		}

	}

	@Test
	public void listar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> itemVenda = new ArrayList<>();

		itemVenda = itemVendaDAO.listar();
		if (itemVenda != null) {
			for (ItemVenda itens : itemVenda) {
				System.out.println(
						itens.getCodigo() + " - " + itens.getQuantidade() + " - " + itens.getProduto().getCodigo()
								+ " - " + itens.getValorParcial() + " - " + itens.getVenda().getCodigo());

			}
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void buscar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = new ItemVenda();

		itemVenda = itemVendaDAO.buscar(1L);
		if (itemVenda != null) {
			System.out.println(itemVenda);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void excluir() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = new ItemVenda();

		itemVenda = itemVendaDAO.buscar(2L);

		if (itemVenda != null) {
			itemVendaDAO.excluir(itemVenda);

			System.out.println("Item Excluido com sucesso.");
		} else {
			System.out.println("Erro ao excluir.");
		}
	}

	@Test
	public void editar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = new ItemVenda();

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = new Produto();

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = new Venda();

		produto = produtoDAO.buscar(1L);
		venda = vendaDAO.buscar(1L);

		if (produto != null && venda != null) {
			
			itemVenda = itemVendaDAO.buscar(1L);
			
			if(itemVenda != null){
				itemVenda.setProduto(produto);
				itemVenda.setQuantidade(new Short("1"));
				itemVenda.setValorParcial(new BigDecimal("111"));
				itemVenda.setVenda(venda);
	
				itemVendaDAO.editar(itemVenda);
	
				System.out.println("Editado com sucesso.");
			}else{
				System.out.println("Erro ao editar a item da venda.");
			}
		} else {
			System.out.println("Erro ao editar a item da venda.");
		}
	}
}
