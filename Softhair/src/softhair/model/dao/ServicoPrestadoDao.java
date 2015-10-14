/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.ServicoPrestado;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class ServicoPrestadoDao {

	Session ss;
	Transaction tx;

	public ServicoPrestadoDao() {

	}

	public ServicoPrestado salvar(ServicoPrestado servico) {

		try {
			
			System.out.println("SALVANDO SP");
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(servico);
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

				e.printStackTrace();
			}
		}

		return servico;
	}

	@SuppressWarnings("unchecked")
	public List<ServicoPrestado> buscar() {
		List<ServicoPrestado> servicos = new ArrayList<ServicoPrestado>();
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			servicos = ss.createCriteria(ServicoPrestado.class).list();
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

				e.printStackTrace();
			}
		}

		return servicos;
	}

	public ServicoPrestado buscarPorId(Integer idServico) {
		// Declaração de variáveis
		ServicoPrestado servicoPrestado;

		// Inicialização de variáveis
		servicoPrestado = null;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			servicoPrestado = (ServicoPrestado) ss.get(ServicoPrestado.class, idServico);
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

				e.printStackTrace();
			}
		}

		return servicoPrestado;

	}

	public ServicoPrestado atualizar(ServicoPrestado servico) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(servico);
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

				e.printStackTrace();
			}
		}

		return servico;
	}

	public boolean deletar(ServicoPrestado servico) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(servico);
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

				e.printStackTrace();
			}
		}

		return deletou;
	}

}
