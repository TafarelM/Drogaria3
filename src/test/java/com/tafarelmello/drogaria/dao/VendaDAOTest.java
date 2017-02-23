package com.tafarelmello.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Cliente;
import com.tafarelmello.drogaria.domain.Funcionario;
import com.tafarelmello.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	public void salvar() throws ParseException {
		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();

		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();

		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionario = funcionarioDAO.buscar(1L);
		cliente = clienteDAO.buscar(2L);

		if (funcionario != null && cliente != null) {
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			venda.setHorario(new Date());
			venda.setPrecoTotal(new BigDecimal(15.20));

			vendaDAO.salvar(venda);

			System.out.println("Salvo com sucesso.");
		} else {
			System.out.println("Erro ao salvar.");
		}

	}

	@Test
	public void listar() {
		List<Venda> vendas = new ArrayList<>();
		VendaDAO vendaDAO = new VendaDAO();

		vendas = vendaDAO.listar();
		if (vendas != null) {
			System.out.println(vendas);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void buscar() {
		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();

		venda = vendaDAO.buscar(2L);
		if (venda != null) {
			System.out.println(venda);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = new Venda();

		venda = vendaDAO.buscar(1L);
		if (venda != null) {
			vendaDAO.excluir(venda);

			System.out.println("Venda Excluida com sucesso.");
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void editar() throws ParseException {
		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();

		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();

		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionario = funcionarioDAO.buscar(1L);
		cliente = clienteDAO.buscar(2L);

		if (funcionario != null && cliente != null) {

			venda = vendaDAO.buscar(1L);

			if (venda != null) {
				venda.setCliente(cliente);
				venda.setFuncionario(funcionario);
				venda.setHorario(new Date());
				venda.setPrecoTotal(new BigDecimal("10"));

				vendaDAO.editar(venda);

				System.out.println("Editado com sucesso.");
			} else {
				System.out.println("Erro ao editar.");
			}
			
		} else {
			System.out.println("Erro ao editar.");
		}

	}
}
