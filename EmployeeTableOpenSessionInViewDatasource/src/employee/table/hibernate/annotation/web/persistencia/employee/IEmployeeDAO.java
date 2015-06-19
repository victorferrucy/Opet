package employee.table.hibernate.annotation.web.persistencia.employee;

import java.util.List;

import employee.table.hibernate.annotation.web.model.Employee;

/**
 * 
 */

/**
 * Interface para definir os métodos da classe EmployeeTable.
 * 
 * @author Baracho
 * 
 * @since 13/05/2013
 * 
 * @version 1.0
 * 
 */
interface IEmployeeDAO {

	public void salvar(Employee employee);

	public List<Employee> consultar();

	public void atualizar(Employee employee);

	public void excluir(Employee employee);
	
	public Integer pesquisar();

	public Employee pesquisar(int employeeID);

	public List<Employee> pesquisar(String nome);

}
