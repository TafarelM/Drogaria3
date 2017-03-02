package com.tafarelmello.drogaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.tafarelmello.drogaria.dao.CidadeDAO;
import com.tafarelmello.drogaria.dao.EstadoDAO;
import com.tafarelmello.drogaria.domain.Cidade;
import com.tafarelmello.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeController implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	@PostConstruct
	public void iniciar() {
		listar();
	}

	public void novo() {
		try {
			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar gerar nova cidade.");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);

			novo();
			listar();

			Messages.addGlobalInfo("Cidade salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Salvar  a cidade.");
			erro.printStackTrace();
		}
	}

	public void listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Cidades.");
			erro.printStackTrace();
		}
	}
	
	public void ListaOdenada() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Cidades.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			listar();

			Messages.addGlobalInfo("Excluido com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar excluir.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar selecionar uma nova cidade.");
			erro.printStackTrace();
		}
	}	

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

}
