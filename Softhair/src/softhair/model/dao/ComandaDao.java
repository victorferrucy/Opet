/**
 * 
 */
package softhair.model.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import softhair.model.Comanda;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ComandaDao {
	private Session ss;
	private Transaction tx;

	public ComandaDao() {
	}

	public Comanda salvar(Comanda comanda) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(comanda);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return comanda;
	}

	/*
	 * @SuppressWarnings("unchecked") public LinkedHashSet<Comanda> buscar() {
	 * LinkedHashSet<Comanda> comandas;
	 * 
	 * comandas = new LinkedHashSet<Comanda>();
	 * 
	 * try { ss = HibernateUtil.getSessionFactory().openSession(); tx =
	 * ss.beginTransaction(); Criteria cr = ss.createCriteria(Comanda.class);
	 * cr.addOrder(Order.asc("idComanda"));
	 * 
	 * comandas = new LinkedHashSet<Comanda>( cr.list()); tx.commit(); } catch
	 * (HibernateException e) { e.printStackTrace(); if (tx.isActive()) {
	 * 
	 * tx.rollback(); } } finally { try { if (ss.isOpen()) {
	 * 
	 * ss.close(); } } catch (Throwable e) {
	 * 
	 * e.printStackTrace(); } }
	 * 
	 * return comandas; }
	 */

	@SuppressWarnings("unchecked")
	public List<Comanda> buscar() {
		List<Comanda> comandas;

		comandas = new ArrayList<Comanda>();

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Criteria cr = ss.createCriteria(Comanda.class);
			cr.addOrder(Order.asc("idComanda"));

			comandas = new ArrayList<Comanda>(cr.list());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return comandas;
	}

	public Comanda buscar(Comanda comanda) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			comanda = (Comanda) ss.get(Comanda.class, comanda.getIdComanda());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return comanda;
	}

	public Comanda atualizar(Comanda comanda) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(comanda);
			tx.commit();

		} catch (HibernateException e) {
			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return comanda;
	}

	public boolean deletar(Comanda comanda) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(comanda);
			tx.commit();

		} catch (HibernateException e) {
			deletou = false;

			e.printStackTrace();

			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return deletou;
	}

	public BigDecimal buscarReceitaMes(Calendar periodo) {

		String sql = "SELECT SUM(c.total) " + "FROM Comanda as c " + "WHERE EXTRACT(month from dataAbertura) = :mes  "
				+ "AND EXTRACT(year from dataAbertura) = :ano ";

		BigDecimal receita;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Query query = ss.createQuery(sql);
			query.setParameter("mes", periodo.get(Calendar.MONTH) + 1);
			query.setParameter("ano", periodo.get(Calendar.YEAR));
			receita = (BigDecimal) query.list().get(0);
			if (receita == null) {

				System.out.println("SEM RECEITA");
			} else {
				System.out.println(receita.toString());
			}
			tx.commit();

		} catch (HibernateException e) {
			receita = null;

			e.printStackTrace();

			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return receita;
	}

	public BigDecimal buscarReceitaPeriodo(Calendar dataInicial, Calendar dataFinal) {

		String sql = "SELECT SUM(c.total)FROM Comanda as c " + "WHERE dataAbertura >= :dataInicial  "
				+ "AND dataAbertura <= :dataFinal ";

		BigDecimal receita;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Query query = ss.createQuery(sql);
			query.setParameter("dataInicial", dataInicial);
			query.setParameter("dataFinal", dataFinal);
			receita = (BigDecimal) query.list().get(0);
			tx.commit();

		} catch (HibernateException e) {
			receita = null;

			e.printStackTrace();

			if (tx.isActive()) {

				tx.rollback();
			}
		} finally {
			try {
				if (ss.isOpen()) {

					ss.close();
				}
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}

		return receita;
	}

}
