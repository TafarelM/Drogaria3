package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Cidade;
import com.tafarelmello.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = new Cidade();

		cidade = cidadeDAO.buscar(1L);
		if (cidade != null) {

			pessoa.setNome("Maria do bairro");
			pessoa.setBairro("Centro");
			pessoa.setCelular("123654752");
			pessoa.setCep("2216111");
			pessoa.setCidade(cidade);
			pessoa.setComplemento("");
			pessoa.setCpf("35594893261");
			pessoa.setEmail("teste@email");
			pessoa.setNumero(new Short("123"));
			pessoa.setRg("123654789");
			pessoa.setRua("Avenida");
			pessoa.setTelefone("4125638569");

			pessoaDAO.salvar(pessoa);

			System.out.println("Cidade salva com sucesso.");
		} else {
			System.out.println("cidade não cadastrada");
		}
	}

	@Test
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> pessoas = new ArrayList<>();

		pessoas = pessoaDAO.listar();

		if (pessoas != null) {
			System.out.println(pessoas);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}

	}

	@Test
	public void buscar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		pessoa = pessoaDAO.buscar(1L);

		if (pessoa != null) {
			System.out.println(pessoa);
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void excluir() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		pessoa = pessoaDAO.buscar(4L);

		if (pessoa != null) {
			pessoaDAO.excluir(pessoa);

			System.out.println("Pessoa excluida com sucesso");
		} else {
			System.out.println("Nenhum registro encontrado.");
		}
	}

	@Test
	public void editar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = new Cidade();

		cidade = cidadeDAO.buscar(2L);
		if (cidade != null) {
			
			pessoa = pessoaDAO.buscar(32L);

			if (pessoa != null) {

				pessoa.setNome("tttttttttt");
				pessoa.setBairro("sssssssssss");
				pessoa.setCelular("123654752");
				pessoa.setCep("2216111");
				pessoa.setCidade(cidade);
				pessoa.setComplemento("");
				pessoa.setCpf("35594893261");
				pessoa.setEmail("teste@email");
				pessoa.setNumero(new Short("333"));
				pessoa.setRg("123654789");
				pessoa.setRua("Avenida");
				pessoa.setTelefone("4125638569");

				pessoaDAO.editar(pessoa);
				
				System.out.println("Cidade editada com sucesso.");
			}else{
				System.out.println("Pessoa não Encontrada.");
			}

		} else {
			System.out.println("cidade não cadastrada.");
		}
	}
}
