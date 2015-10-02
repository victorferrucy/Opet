package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Cliente;
import softhair.model.Contato;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ContatoDao {
	private Session ss;
	private Transaction tx;

	public Contato salvar(Contato contato) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(contato);
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

		return contato;
	}

	@SuppressWarnings("unchecked")
	public List<Contato> buscar() {
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			contatos = ss.createCriteria(Contato.class).list();
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

		return contatos;
	}

	public Contato buscar(Contato contato) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			contato = (Contato) ss.get(Contato.class, contato.getIdContato());
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

		return contato;
	}

	public Contato atualizar(Contato contato) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(contato);
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

		return contato;
	}

	public boolean deletar(Contato contato) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(contato);
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
}
