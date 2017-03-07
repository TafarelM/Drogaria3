package com.tafarelmello.drogaria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.tafarelmello.drogaria.dao.CidadeDAO;
import com.tafarelmello.drogaria.dao.EstadoDAO;
import com.tafarelmello.drogaria.dao.PessoaDAO;
import com.tafarelmello.drogaria.domain.Cidade;
import com.tafarelmello.drogaria.domain.Estado;
import com.tafarelmello.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class PessoaController implements Serializable {

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;
	private Estado estado;

	@PostConstruct
	public void iniciar() {
		listar();
	}

	public void novo() {

		try {
			pessoa = new Pessoa();
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

			cidades = new ArrayList<Cidade>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar gerar uma nova Pessoa");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);

			novo();
			listar();

			Messages.addGlobalInfo("Pessoa salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar a Pessoa");
			erro.printStackTrace();
		}

	}

	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Pessoas.");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);

			listar();

			Messages.addGlobalInfo("Produto excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu ao tentar Excluir.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");			
			estado = pessoa.getCidade().getEstado();			
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			popular();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu ao tentar editar.");
			erro.printStackTrace();
		}
	}

	public void popular() {

		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu ao tentar filtar as cidades.");
			erro.printStackTrace();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
