/**
 * 
 */
package employee.table.hibernate.annotation.web.util;

import java.util.List;

import employee.table.hibernate.annotation.web.model.Employee;
import employee.table.hibernate.annotation.web.persistencia.employee.PersistenciaEmployee;

/**
 * Classe para testar a conectividade utilizando Hibernate.
 * 
 * @author Baracho
 * 
 * @since 22/09/2013
 * 
 * @version 1.0
 * 
 */

public class TesteConnectivityHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1");
		PersistenciaEmployee persistenciaEmployee = new PersistenciaEmployee();
		System.out.println("2");
		List<Employee> employees = null;
		System.out.println("3");
		employees = persistenciaEmployee.consultar();
		System.out.println("4");
		if (employees != null && employees.size() > 0) {

			for (Employee e : employees) {

				System.out.println(e.toString());
			}

		}

	}

}
