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

	@SuppressWarnings({ "finally", "unchecked" })
	public List<HorarioReservado> buscar() {
		List<HorarioReservado> horariosReservados = null;
		try {
			tx = ss.beginTransaction();
			horariosReservados = ss.createCriteria(HorarioReservado.class)
					.list();
			
		} catch (HibernateException e) {
			// TODO: handle exception

			if (this.tx.isActive()) {

				this.tx.rollback();
			}

		} finally {

			try {

				if (ss.isOpen()) {

					ss.close();
				}

			} catch (Throwable e) {
				// TODO: handle exception

				System.out.println(e.getMessage());
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
