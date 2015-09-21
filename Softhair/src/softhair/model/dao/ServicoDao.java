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
import softhair.model.Servico;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ServicoDao {
	Session ss;
	Transaction tx;

	public ServicoDao() {

	}

	public Servico salvar(Servico servico) {
	
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(servico);
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

		return servico;
	}

	@SuppressWarnings("unchecked")
	public List<Servico> buscar() {
		List<Servico> servicos = new ArrayList<Servico>();
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			servicos = ss.createCriteria(Servico.class).list();
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

		return servicos;
	}

	public Servico buscarPorId(Integer idServico){
		// Declaração de variáveis
		Servico servico;
		
		// Inicialização de variáveis
		servico = null;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			servico = (Servico)ss.get(Servico.class, idServico);
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

		return servico;
		
	}
	
	public Servico atualizar(Servico servico) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(servico);
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

		return servico;
	}

	public boolean deletar(Servico servico) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(servico);
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
