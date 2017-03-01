package com.tafarelmello.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.tafarelmello.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(entidade);
			transaction.commit();

		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;

		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = session.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = session.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}

	public void excluir(Entidade entidade) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(entidade);
			transaction.commit();

		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;

		} finally {
			session.close();
		}
	}

	public void editar(Entidade entidade) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(entidade);
			transaction.commit();

		} catch (RuntimeException erro) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw erro;

		} finally {
			session.close();
		}
	}

	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
