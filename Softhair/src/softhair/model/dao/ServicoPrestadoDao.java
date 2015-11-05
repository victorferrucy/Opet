/**
 * 
 */
package softhair.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	public List<ServicoPrestado> buscarServicosPrestadosFuncionario(int idFuncionario, Calendar dataInicial,
			Calendar dataFinal) {
		 
		String sql = "FROM ServicoPrestado sp" 
		+ " WHERE sp.funcionario.idColaborador = :idFuncionario" 
				+ " AND sp.idServicoPrestado IN "
				+ " ( SELECT sp.idServicoPrestado  "
				+ "	FROM Comanda c"
				+ " inner join c.servicosPrestados sp"
				+ "	WHERE c.dataAbertura >= :dataInicial "
				+ " AND c.dataAbertura <= :dataFinal )";

		List<ServicoPrestado> servicosPrestadosFuncionario;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Query query = ss.createQuery(sql);

			query.setParameter("dataInicial", dataInicial);
			query.setParameter("dataFinal", dataFinal);
			query.setParameter("idFuncionario", idFuncionario);
			servicosPrestadosFuncionario = query.list();
			tx.commit();

		} catch (HibernateException e) {
			servicosPrestadosFuncionario = null;

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

		return servicosPrestadosFuncionario;

	}

}
