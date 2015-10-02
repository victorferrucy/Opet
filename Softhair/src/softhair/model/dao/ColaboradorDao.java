package softhair.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Colaborador;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ColaboradorDao {

	Session ss;
	Transaction tx;

	public Colaborador salvar(Colaborador colaborador) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(colaborador);
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

				System.out.println(e.getMessage());
			}
		}

		return colaborador;
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> buscar() {
		List<Colaborador> colaboradores = null;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			colaboradores = ss.createCriteria(Colaborador.class).list();
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

		return colaboradores;
	}

	public Colaborador atualizar(Colaborador colaborador) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(colaborador);
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

		return colaborador;
	}

	public boolean deletar(Colaborador colaborador) {
		boolean deletou = true;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(colaborador);
			tx.commit();

		} catch (HibernateException e) {
			deletou = false;
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

}
