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
		ss = HibernateUtil.getSessionFactory().openSession();
		try {

			tx = ss.beginTransaction();
			ss.save(funcionario);
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

		return funcionario;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscar() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		ss = HibernateUtil.getSessionFactory().openSession();
		try {

			tx = ss.beginTransaction();
			funcionarios = ss.createCriteria(Funcionario.class).list();
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

		return funcionarios;
	}
	
	
	public Funcionario buscarPorId(Integer id) {
		// Declaração de variáveis
		Funcionario funcionario;
		
		// Inicialização de variáveis
		funcionario = null;
		
		ss = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = ss.beginTransaction();
			funcionario = (Funcionario)ss.get(Funcionario.class, id);
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

		return funcionario;
	}

	public Funcionario atualizar(Funcionario funcionario) {

		try {

			tx = ss.beginTransaction();
			ss.update(funcionario);
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

		return funcionario;
	}

	public boolean deletar(Funcionario funcionario) {
		boolean deletou = true;
		try {

			tx = ss.beginTransaction();
			ss.delete(funcionario);
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
