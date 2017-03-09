package com.tafarelmello.drogaria.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.tafarelmello.drogaria.dao.FuncionarioDAO;
import com.tafarelmello.drogaria.dao.ProdutoDAO;
import com.tafarelmello.drogaria.domain.Cliente;
import com.tafarelmello.drogaria.domain.Funcionario;
import com.tafarelmello.drogaria.domain.ItemVenda;
import com.tafarelmello.drogaria.domain.Produto;
import com.tafarelmello.drogaria.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaController implements Serializable {

	private List<Produto> produtos;
	private List<ItemVenda> itensVenda;
	private Venda venda;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;

	@PostConstruct
	public void iniciar() {
		listar();

		itensVenda = new ArrayList<>();

		venda = new Venda();
		venda.setPrecoTotal(new BigDecimal(0.00));
	}

	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}

	public void adicionar(ActionEvent evento) {
		Produto produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

		int achou = -1;
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getProduto().equals(produto)) {
				achou = posicao;
			}
		}

		if (achou < 0) {
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setValorParcial(produto.getPreco());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("1"));

			itensVenda.add(itemVenda);
		} else {
			ItemVenda itemVenda = itensVenda.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
			itemVenda.setValorParcial(produto.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
		}

		calcularTotal();

	}

	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = (ItemVenda) evento.getComponent().getAttributes().get("itemSelecionado");
		int achou = -1;
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getProduto().equals(itemVenda.getProduto())) {
				achou = posicao;
			}
		}

		if (achou > -1 && itemVenda.getQuantidade() > 1) {
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() - 1 + ""));
			itemVenda.setValorParcial(itemVenda.getValorParcial().subtract(itemVenda.getProduto().getPreco()));

		} else {
			itensVenda.remove(achou);
		}

		calcularTotal();
	}

	public void calcularTotal() {
		venda.setPrecoTotal(new BigDecimal("0.00"));

		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			ItemVenda itemVenda = itensVenda.get(posicao);
			venda.setPrecoTotal(venda.getPrecoTotal().add(itemVenda.getValorParcial()));
		}
	}

	public void finalizarCompra() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar("");			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorre um erro ao tentar finalizar a venda.");
		}
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
