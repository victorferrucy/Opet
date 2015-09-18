/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Comanda;
import softhair.model.Contato;
import softhair.util.HibernateUtil;


/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ComandaDao {
	private Session ss;
	private Transaction tx;
	
	public ComandaDao(){}
	
	public Comanda salvar(Comanda comanda) {
		
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(comanda);
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

		return comanda;
	}

	@SuppressWarnings("unchecked")
	public List<Comanda> buscar() {
		List<Comanda> comandas = new ArrayList<Comanda>();
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			comandas = ss.createCriteria(Comanda.class).list();
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

		return comandas;
	}
	
	public Comanda buscar(Comanda comanda) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			comanda =  (Comanda) ss.get(Comanda.class, comanda.getIdComanda());
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

		return comanda;
	}

	public Comanda atualizar(Comanda comanda) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(comanda);
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
			System.out.println("ERRO DELETAR CONTATO \n" + e);
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
