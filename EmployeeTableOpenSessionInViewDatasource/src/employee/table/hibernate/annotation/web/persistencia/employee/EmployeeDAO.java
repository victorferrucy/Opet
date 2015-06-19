package employee.table.hibernate.annotation.web.persistencia.employee;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import employee.table.hibernate.annotation.web.model.Employee;

/**
 * 
 */

/**
 * Classe para realizar as operações de banco de dados para um Employee.
 * 
 * @author Baracho
 * 
 * @since 06/10/2013
 * 
 * @version 2.0
 * 
 */

public class EmployeeDAO implements IEmployeeDAO {

	// Variáveis de instância

	private Session session;

	// Função construtora da classe

	public EmployeeDAO() {

	}

	public EmployeeDAO(Session session) {

		setSession(session);
	}

	// Métodos de acesso

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	// Operações da classe

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#salvar(Employee)
	 */
	@Override
	public void salvar(Employee employee) {
		// TODO Auto-generated method stub

		System.out.println(employee.toString());

		session.save(employee);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#consultar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> consultar() {
		// TODO Auto-generated method stub

		Query query = null;

		List<Employee> resultado = null;

		query = session
				.createQuery("from Employee emp order by emp.firstName, emp.lastName asc");

		resultado = query.list();

		return resultado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#atualizar(Employee)
	 */
	@Override
	public void atualizar(Employee employee) {
		// TODO Auto-generated method stub

		session.update(employee);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#excluir(Employee)
	 */
	@Override
	public void excluir(Employee employee) {
		// TODO Auto-generated method stub

		session.delete(employee);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#pesquisar(java.lang.String)
	 */
	@Override
	public Integer pesquisar() {
		// TODO Auto-generated method stub

		Query query = null;

		Integer employeeID = null;

		query = session
				.createQuery("select max(emp.employeeID) from Employee emp");

		employeeID = (Integer) query.uniqueResult();

		return employeeID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#pesquisar(int)
	 */
	@Override
	public Employee pesquisar(int employeeID) {
		// TODO Auto-generated method stub

		Query query = null;

		Employee employee = null;

		query = session
				.createQuery("from Employee where employeeID = :parametro");

		query.setInteger("parametro", employeeID);

		employee = (Employee) query.uniqueResult();

		return employee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IEmployeeDAO#pesquisar(java.lang.String)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> pesquisar(String nome) {
		// TODO Auto-generated method stub

		nome = "%" + nome.toUpperCase() + "%";

		Query query = null;

		List<Employee> resultado = null;

		query = session
				.createQuery("from Employee emp where emp.firstName || ' ' || emp.lastName LIKE :parametro");

		query.setString("parametro", nome);

		resultado = query.list();

		return resultado;
	}

}
