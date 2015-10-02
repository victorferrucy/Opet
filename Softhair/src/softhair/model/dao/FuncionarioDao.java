/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Funcionario;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class FuncionarioDao {
	Session ss;
	Transaction tx;

	public FuncionarioDao() {

	}

	public Funcionario salvar(Funcionario funcionario) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(funcionario);
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

		return funcionario;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscar() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			funcionarios = ss.createCriteria(Funcionario.class).list();
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

		return funcionarios;
	}

	public Funcionario buscarPorId(Integer id) {
		// Declaração de variáveis
		Funcionario funcionario;

		// Inicialização de variáveis
		funcionario = null;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			funcionario = (Funcionario) ss.get(Funcionario.class, id);
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

		return funcionario;
	}

	public Funcionario atualizar(Funcionario funcionario) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(funcionario);
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

		return funcionario;
	}

	public boolean deletar(Funcionario funcionario) {
		boolean deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(funcionario);
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
