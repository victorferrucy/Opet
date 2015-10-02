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
	
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(fornecedor);
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

		return fornecedor;
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscar() {
		List<Fornecedor> clientes = new ArrayList<Fornecedor>();
		
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			clientes = ss.createCriteria(Fornecedor.class).list();
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

		return clientes;
	}

	public Fornecedor atualizar(Fornecedor fornecedor) {
		
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(fornecedor);
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

		return fornecedor;
	}

	public boolean deletar(Fornecedor fornecedor) {
		boolean deletou = true;
		
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(fornecedor);
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
