package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Cliente;
import com.tafarelmello.drogaria.domain.Pessoa;

public class ClienteDAOTest {

	@Test
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();

		pessoa = pessoaDAO.buscar(5L);
		if (pessoa != null) {
			cliente.setDataCadastro(new Date());
			cliente.setLiberado(true);
			cliente.setPessoa(pessoa);

			clienteDAO.salvar(cliente);

			System.out.println("Pessoa cadastrada com sucesso.");
		} else {
			System.out.println("Pessoa não encontrada.");
		}

	}

	@Test
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = new ArrayList<>();

		clientes = clienteDAO.listar();
		if (clientes != null) {
			System.out.println(clientes);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void buscar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();

		cliente = clienteDAO.buscar(4L);
		if (cliente != null) {
			System.out.println(cliente);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void excluir() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();

		cliente = clienteDAO.buscar(6L);
		if (cliente != null) {
			clienteDAO.excluir(cliente);

			System.out.println("Cliente excluido com sucesso.");
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void editar() {
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();

		pessoa = pessoaDAO.buscar(1L);
		if (pessoa != null) {

			cliente = clienteDAO.buscar(2L);			
			
			if (cliente != null) {
				cliente.setDataCadastro(new Date());
				cliente.setLiberado(true);
				cliente.setPessoa(pessoa);

				clienteDAO.editar(cliente);

				System.out.println("Cliente cadastrada com sucesso.");
			}else{
				System.out.println("Cliente não encontrado.");
			}

		} else {
			System.out.println("Pessoa não encontrada.");
		}
	}
}
