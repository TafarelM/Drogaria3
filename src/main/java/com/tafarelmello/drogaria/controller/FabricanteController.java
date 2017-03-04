package com.tafarelmello.drogaria.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;
import com.tafarelmello.drogaria.dao.FabricanteDAO;
import com.tafarelmello.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteController implements Serializable {

	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	@PostConstruct
	public void iniciar() {
		listar();
	}

	public void novo() {

		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			/*
			 * FabricanteDAO fabricanteDAO = new FabricanteDAO();
			 * fabricanteDAO.merge(fabricante);
			 */

			Client client = ClientBuilder.newClient();
			WebTarget caminho = client.target("http://localhost:8080/Drogaria/rest/fabricante");

			Gson gson = new Gson();
			String json = gson.toJson(fabricante);

			caminho.request().post(Entity.json(json));

			novo();
			listar();

			Messages.addFlashGlobalInfo("Salvo com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o Fabricante.");
			erro.printStackTrace();
		}
	}

	public void listar() {
		try {
			/*
			 * FabricanteDAO fabricanteDAO = new FabricanteDAO(); fabricantes =
			 * fabricanteDAO.listar();
			 */

			Client client = ClientBuilder.newClient();
			WebTarget caminho = client.target("http://localhost:8080/Drogaria/rest/fabricante");
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);

			fabricantes = Arrays.asList(vetor);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar o Fabricante.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);

			listar();

			Messages.addFlashGlobalInfo("excluido com sucesso.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar excluir o Fabricante.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

			// listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar editar o Fabricante.");
			erro.printStackTrace();
		}
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

}
