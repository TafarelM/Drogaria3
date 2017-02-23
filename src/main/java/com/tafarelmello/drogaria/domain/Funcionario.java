package com.tafarelmello.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {

	@Column(length = 15, nullable = false)
	private String carteiraTrabalho;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@OneToOne
	@JoinColumn(nullable = false, unique = true)
	private Pessoa pessoa;

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [carteiraTrabalho=" + carteiraTrabalho + ", dataAdmissao=" + dataAdmissao + ", pessoa="
				+ pessoa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((carteiraTrabalho == null) ? 0 : carteiraTrabalho.hashCode());
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (carteiraTrabalho == null) {
			if (other.carteiraTrabalho != null)
				return false;
		} else if (!carteiraTrabalho.equals(other.carteiraTrabalho))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

}