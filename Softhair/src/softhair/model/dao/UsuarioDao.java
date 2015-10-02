/**
 * 
 */
package softhair.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		ss = HibernateUtil.getSessionFactory().openSession();
	}

	public Usuario salvar(Usuario usuario) {
		try {
			tx = ss.beginTransaction();
			ss.save(usuario);
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

		return usuario;
	}

	public List<Usuario> buscar() {

		return null;
	}

	public Usuario buscar(Usuario usuario) {
		Usuario usuario2 = null;
		return usuario2;
	}

	public Usuario atualizar() {

		return null;
	}

	public boolean deletar() {

		return false;
	}

}
