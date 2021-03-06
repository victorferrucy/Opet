/**
 * 
 */
package softhair.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import softhair.model.CargoSistema;
import softhair.model.Usuario;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class UsuarioDao {
	Session ss;
	Transaction tx;

	public UsuarioDao() {

	}

	public Usuario salvar(Usuario usuario) {
		try {
			System.out.println("Salvando -------------------");
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(usuario);
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

		return usuario;
	}

	public List<Usuario> buscar() {

		List<Usuario> usuarios;

		usuarios = new ArrayList<Usuario>();
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			usuarios = ss.createCriteria(Usuario.class).list();
			for (Usuario u : usuarios) {
				u.getCargo().size();
			}
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

		return usuarios;
	}

	public Usuario buscar(String loginUsuario) {
		Usuario usuario;

		usuario = null;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Criteria criteria = ss.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("login", loginUsuario));
			usuario = (Usuario) (criteria.uniqueResult());
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

		return usuario;
	}

	public Usuario atualizar(Usuario usuario) {

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(usuario);
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

		return usuario;
	}

	public boolean deletar(Usuario usuario) {

		boolean deletou;
		deletou = true;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(usuario);
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

	public List<CargoSistema> buscarCargos(Integer idUsuario) {
		List<CargoSistema> cargos;
		cargos = new ArrayList<CargoSistema>();

		Usuario usuario;
		usuario = null;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Criteria criteria = ss.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("idUsuario", idUsuario));
			usuario = (Usuario) (criteria.uniqueResult());
			usuario.getCargo().size();
			cargos = usuario.getCargo();
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

		return cargos;

	}
	
	public List<CargoSistema> buscarCargos() {
		List<CargoSistema> cargos;
		cargos = new ArrayList<CargoSistema>();

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Criteria criteria = ss.createCriteria(CargoSistema.class);
			cargos = criteria.list();
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

		return cargos;

	}
	
	public CargoSistema buscarCargo(Integer idCargo) {
		CargoSistema cargo;
		cargo = null;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			Criteria criteria = ss.createCriteria(CargoSistema.class);
			criteria.add(Restrictions.eq("idCargoSistema", idCargo));
			cargo = (CargoSistema) criteria.uniqueResult();
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

		return cargo;

	}

}
