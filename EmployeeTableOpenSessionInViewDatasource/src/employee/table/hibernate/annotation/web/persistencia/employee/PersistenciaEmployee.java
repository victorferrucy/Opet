/**
 * 
 */
package employee.table.hibernate.annotation.web.persistencia.employee;

import java.util.List;

import org.hibernate.Session;

import employee.table.hibernate.annotation.web.model.Employee;
import employee.table.hibernate.annotation.web.util.DAOFactory;

/**
 * Classe para realizar a interface com a camada de persist�ncia para a entidade
 * Employee.
 * 
 * @author Baracho
 * 
 * @since 01/04/2014
 * 
 * @version 1.0
 * 
 */

public class PersistenciaEmployee implements IEmployeeDAO {

	// Declara��o de vari�veis

	private EmployeeDAO employeeDAO;

	// Fun��o construtora

	public PersistenciaEmployee() {

		employeeDAO = DAOFactory.getEmployeeDAOFactory();

	}

	public PersistenciaEmployee(Session session) {

		employeeDAO = new EmployeeDAO(session);
	}

	// M�todos de acesso

	// Opera��es da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#salvar
	 * (employee.table.hibernate.annotation.web.model.Employee)
	 */
	@Override
	public void salvar(Employee employee) {
		// TODO Auto-generated method stub

		employeeDAO.salvar(employee);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#consultar
	 * ()
	 */
	@Override
	public List<Employee> consultar() {
		// TODO Auto-generated method stub

		return employeeDAO.consultar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#atualizar
	 * (employee.table.hibernate.annotation.web.model.Employee)
	 */
	@Override
	public void atualizar(Employee employee) {
		// TODO Auto-generated method stub

		employeeDAO.atualizar(employee);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#excluir
	 * (employee.table.hibernate.annotation.web.model.Employee)
	 */
	@Override
	public void excluir(Employee employee) {
		// TODO Auto-generated method stub

		employeeDAO.excluir(employee);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#pesquisar
	 * ()
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub
		return employeeDAO.pesquisar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#pesquisar
	 * (int)
	 */
	@Override
	public Employee pesquisar(int employeeID) {
		// TODO Auto-generated method stub
		return employeeDAO.pesquisar(employeeID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * employee.table.hibernate.annotation.web.persistencia.IEmployeeDAO#pesquisar
	 * (java.lang.String)
	 */
	@Override
	public List<Employee> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return employeeDAO.pesquisar(nome);
	}

}
