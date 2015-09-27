/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import softhair.model.Cliente;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ClienteDao {
	Session ss;
	Transaction tx;

	public ClienteDao() {

	}

	public Cliente salvar(Cliente cliente) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(cliente);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
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

		return cliente;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			clientes = ss.createCriteria(Cliente.class).list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
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

	public Cliente buscar(Cliente clienteSel) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			clienteSel = (Cliente) ss.get(Cliente.class, clienteSel.getIdColaborador());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
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

		return clienteSel;
	}
	
	public Cliente buscarPorId(Integer idCliente){
		// Declaração de variáveis
		Cliente cliente;
		
		// Inicialização de variáveis
		cliente = null;
		
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			cliente = (Cliente) ss.get(Cliente.class, idCliente);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
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

		return cliente;
		
		
	}

	public Cliente atualizar(Cliente cliente) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(cliente);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
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

		return cliente;
	}

	public boolean deletar(Cliente cliente) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(cliente);
			tx.commit();

		} catch (HibernateException e) {
			deletou = false;
			e.printStackTrace();
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
