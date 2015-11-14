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

	}

	public HorarioReservado salvar(HorarioReservado hr) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.save(hr);
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

		return hr;
	}

	public List<HorarioReservado> buscar() {
		List<HorarioReservado> horariosReservados;

		horariosReservados = null;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
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
		}

		return horariosReservados;
	}

	public HorarioReservado buscar(Integer idHorarioReservado) {
		HorarioReservado horariosReservado;

		horariosReservado = null;

		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			horariosReservado = (HorarioReservado) ss.get(HorarioReservado.class, idHorarioReservado);

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
			return horariosReservado;
		}

	}

	public HorarioReservado atualizar(HorarioReservado hr) {
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.update(hr);
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

		return hr;
	}

	public boolean deletar(HorarioReservado hr) {
		boolean deletou;

		deletou = true;
		try {
			ss = HibernateUtil.getSessionFactory().openSession();
			tx = ss.beginTransaction();
			ss.delete(hr);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			deletou = false;
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
