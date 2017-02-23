package com.tafarelmello.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tafarelmello.drogaria.domain.Pessoa;
import com.tafarelmello.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		pessoa = pessoaDAO.buscar(2L);
		if (pessoa != null) {
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);//precisa verificar usuario unico ainda
			usuario.setSenha("123");
			usuario.setTipo('a');
			
			usuarioDAO.salvar(usuario);
			
			System.out.println("Usuario salvo com sucesso.");
		}else{
			System.out.println("Pessoa não encontrada.");
		}

	}

	@Test
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios = usuarioDAO.listar();
		if(usuarios != null){
			System.out.println(usuarios);
		}else{
			System.out.println("Nenhum registor encontrado.");
		}
		
	}

	@Test
	public void buscar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = usuarioDAO.buscar(2L);
		if(usuario != null){
			System.out.println(usuario);
		}else{
			System.out.println("Nenhum registor encontrado.");
		}
	}

	@Test
	public void excluir() {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuario = usuarioDAO.buscar(2L);
		if(usuario != null){
			usuarioDAO.excluir(usuario);
			
			System.out.println("Excluido com sucesso.");
		}else{
			System.out.println("Nenhum registro encontrado");
		}
	}

	@Test
	public void editar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();

		pessoa = pessoaDAO.buscar(2L);
		if (pessoa != null) {
			
			usuario = usuarioDAO.buscar(4L);
			
			if(usuario != null){
				usuario.setAtivo(true);
				usuario.setPessoa(pessoa);//precisa verificar usuario unico ainda
				usuario.setSenha("2313");
				usuario.setTipo('a');
				
				usuarioDAO.editar(usuario);
				
				System.out.println("Usuario editado com sucesso.");
			}else{
				System.out.println("Usuario não encontrado.");
			}
			
		}else{
			System.out.println("Pessoa não encontrada.");
		}
	}
}
