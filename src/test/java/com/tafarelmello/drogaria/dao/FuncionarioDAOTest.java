package com.tafarelmello.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Funcionario;
import com.tafarelmello.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {

	@Test
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		pessoa = pessoaDAO.buscar(1L);
		if (pessoa != null) {
			funcionario.setCarteiraTrabalho("2313");
			funcionario.setDataAdmissao(new Date());
			funcionario.setPessoa(pessoa);

			funcionarioDAO.salvar(funcionario);

			System.out.println("Pessoa cadastrada com sucesso.");
		} else {
			System.out.println("Pessoa não encontrada.");
		}
	}

	@Test
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> funcionarios = new ArrayList<>();

		funcionarios = funcionarioDAO.listar();
		if (funcionarios != null) {
			System.out.println(funcionarios);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void buscar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();

		funcionario = funcionarioDAO.buscar(2L);
		if (funcionario != null) {
			System.out.println(funcionario);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void excluir() {
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionario = funcionarioDAO.buscar(2L);
		if (funcionario != null) {
			funcionarioDAO.excluir(funcionario);

			System.out.println("Excluido com sucesso.");
		} else {
			System.out.println("Funcionario não encontrado.");
		}
	}

	@Test
	public void editar() throws ParseException {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		pessoa = pessoaDAO.buscar(1L);

		if (pessoa != null) {

			funcionario = funcionarioDAO.buscar(1L);

			if (funcionario != null) {
				funcionario.setCarteiraTrabalho("2222");
				funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
				funcionario.setPessoa(pessoa);

				funcionarioDAO.editar(funcionario);

				System.out.println("Funcionario editada com sucesso.");
			} else {
				System.out.println("Funcionario não encontrado.");
			}

		} else {
			System.out.println("Pessoa não encontrada.");
		}
	}
}
