/**
 * 
 */
package employee.table.hibernate.annotation.web.util;

import employee.table.hibernate.annotation.web.persistencia.employee.EmployeeDAO;

/**
 * Classe construtora das DAOs.
 * 
 * @author Baracho
 * 
 * @since 06/10/2014
 * 
 * @version 1.0
 * 
 */
public class DAOFactory {

	/*
	 * Função construtora
	 */

	public DAOFactory() {

	}

	/* ************ EmployeeDAO **************** */

	public static EmployeeDAO getEmployeeDAOFactory() {

		EmployeeDAO employeeDAO = new EmployeeDAO();

		employeeDAO.setSession(HibernateUtil.getSessionFactory()
				.getCurrentSession());

		return employeeDAO;

	}

}
