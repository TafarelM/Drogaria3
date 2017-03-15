package com.tafarelmello.drogaria.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.tafarelmello.drogaria.dao.ProdutoDAO;
import com.tafarelmello.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoController2 implements Serializable {
	private Produto produto;
	private Boolean exibePainelDados;
	
	@PostConstruct
	public void novo(){
		produto = new Produto();
		exibePainelDados = false;
	}
	
	public void buscar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto resultado = produtoDAO.buscar(produto.getCodigo());
			
			if(resultado == null){
				produto = new Produto();
				exibePainelDados = false;
				
				Messages.addGlobalWarn("Não existe produto cadastrado para o código.");
			}else{
				exibePainelDados = true;
				produto = resultado;
			}
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar o produto.");
			erro.printStackTrace();
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Boolean getExibePainelDados() {
		return exibePainelDados;
	}

	public void setExibePainelDados(Boolean exibePainelDados) {
		this.exibePainelDados = exibePainelDados;
	}

}
