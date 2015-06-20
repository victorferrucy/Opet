package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		ss = HibernateUtil.getSessionFactory().openSession();
		try {

			tx = ss.beginTransaction();
			ss.save(contato);
			tx.commit();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			if (this.tx.isActive()) {

				this.tx.rollback();
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

		return contato;
	}

	@SuppressWarnings("unchecked")
	public List<Contato> buscar() {
		List<Contato> contatos = new ArrayList<Contato>();
		ss = HibernateUtil.getSessionFactory().openSession();
		try {

			tx = ss.beginTransaction();
			contatos = ss.createCriteria(Contato.class).list();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			if (this.tx.isActive()) {

				this.tx.rollback();
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

		return contatos;
	}

	public Contato atualizar(Contato contato) {

		try {

			tx = ss.beginTransaction();
			ss.update(contato);
			tx.commit();

		} catch (HibernateException e) {
			if (this.tx.isActive()) {

				this.tx.rollback();
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

		return contato;
	}

	public boolean deletar(Contato contato) {
		boolean deletou = true;
		try {

			tx = ss.beginTransaction();
			ss.delete(contato);
			tx.commit();

		} catch (HibernateException e) {
			deletou = false;
			if (this.tx.isActive()) {

				this.tx.rollback();
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

		return deletou;
	}
}
