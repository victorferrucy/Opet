/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Fornecedor;
import softhair.util.HibernateUtil;


/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class FornecedorDao {
	Session ss;
	Transaction tx;

	public FornecedorDao() {

	}

	public Fornecedor salvar(Fornecedor fornecedor) {
		ss = HibernateUtil.getSessionFactory().openSession();
		try {

			tx = ss.beginTransaction();
			ss.save(fornecedor);
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

		return fornecedor;
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscar() {
		List<Fornecedor> clientes = new ArrayList<Fornecedor>();
		ss = HibernateUtil.getSessionFactory().openSession();
		try {

			tx = ss.beginTransaction();
			clientes = ss.createCriteria(Fornecedor.class).list();
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

		return clientes;
	}

	public Fornecedor atualizar(Fornecedor fornecedor) {

		try {

			tx = ss.beginTransaction();
			ss.update(fornecedor);
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

		return fornecedor;
	}

	public boolean deletar(Fornecedor fornecedor) {
		boolean deletou = true;
		try {

			tx = ss.beginTransaction();
			ss.delete(fornecedor);
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
