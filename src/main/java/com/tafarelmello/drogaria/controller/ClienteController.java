package com.tafarelmello.drogaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.tafarelmello.drogaria.dao.ClienteDAO;
import com.tafarelmello.drogaria.domain.Cliente;
import com.tafarelmello.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Pessoa> pessoas;

	@PostConstruct
	public void inicar() {
		listar();
	}

	public void novo() {
		try {
			cliente = new Cliente();

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar gerar um cliente.");
			erro.printStackTrace();
		}
	}

	public void salvar() {

	}

	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("dataCadastro");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Clientes.");
			erro.printStackTrace();
		}
	}

	public void excluir() {

	}

	public void editar() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
