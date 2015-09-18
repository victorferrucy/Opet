/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Contato;
import softhair.model.Endereco;
import softhair.util.HibernateUtil;


/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class EnderecoDao {
	private Session ss;
	private Transaction tx;
	
	public EnderecoDao(){
		
		
	}
	
	public Endereco salvar(Endereco endereco) {
		
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(endereco);
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

		return endereco;
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> buscar() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
	
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			enderecos = ss.createCriteria(Endereco.class).list();
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

		return enderecos;
	}

	public Endereco buscar(Endereco endereco) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			endereco =  (Endereco) ss.get(Endereco.class, endereco.getIdEndereco());
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

		return endereco;
	}
	
	public Endereco atualizar(Endereco endereco) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(endereco);
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

		return endereco;
	}

	public boolean deletar(Endereco endereco) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(endereco);
			tx.commit();

		} catch (HibernateException e) {
			deletou = false;
			System.out.println("ERRO DELETAR ENDERECO " + e);
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
