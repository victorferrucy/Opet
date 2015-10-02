/**
 * 
 */
package softhair.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.HorarioReservado;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class HorarioReservadoDao {
	Session ss;
	Transaction tx;

	public HorarioReservadoDao() {

		ss = HibernateUtil.getSessionFactory().openSession();
	}

	public HorarioReservado salvar() {

		return null;
	}

	public List<HorarioReservado> buscar() {
		List<HorarioReservado> horariosReservados;

		horariosReservados = null;

		try {
			tx = ss.beginTransaction();
			horariosReservados = (List<HorarioReservado>) ss.createCriteria(HorarioReservado.class).list();

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
			return horariosReservados;
		}

	}

	public HorarioReservado atualizar() {

		return null;
	}

	public boolean deletar() {

		return false;
	}

}
