package com.tafarelmello.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.tafarelmello.drogaria.domain.Funcionario;
import com.tafarelmello.drogaria.util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO<Funcionario> {

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarOrdenado() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = session.createCriteria(Funcionario.class);
			consulta.createAlias("pessoa", "p");
			consulta.addOrder(Order.asc("p.nome"));
			List<Funcionario> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}

}
