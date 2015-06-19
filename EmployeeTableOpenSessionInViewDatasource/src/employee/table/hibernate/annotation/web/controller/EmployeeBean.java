/**
 * 
 */
package employee.table.hibernate.annotation.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import employee.table.hibernate.annotation.web.model.Employee;
import employee.table.hibernate.annotation.web.persistencia.employee.PersistenciaEmployee;

@Named("employeeBean")
@SessionScoped
/**
 * 
 * 
 * @author Baracho
 * 
 * @since 22/09/2013
 * 
 * @version 1.0
 * 
 */
public class EmployeeBean implements Serializable {

	// Variaveis de instancia

	/**
	 * 
	 */
	private static final long serialVersionUID = 8449461844315249486L;

	private Employee employee;

	private List<Employee> resultado;

	private PersistenciaEmployee persistenciaEmployee;

	/**
	 * 
	 */
	public EmployeeBean() {
		// TODO Auto-generated constructor stub

		employee = new Employee();

		persistenciaEmployee = new PersistenciaEmployee();
	}

	// M�todos de acesso

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {

		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {

		this.employee = employee;
	}

	/**
	 * @return the resultado
	 */
	public List<Employee> getResultado() {
		return resultado;
	}

	// Opera��es da classe

	public String confirmarCadastro() {

		return "confirmarCadastro";
	}

	public String salvar() {

		persistenciaEmployee = new PersistenciaEmployee();

		persistenciaEmployee.salvar(employee);

		return "mostrarCadastro";
	}

	public List<Employee> getConsulta() {

		persistenciaEmployee = new PersistenciaEmployee();

		return persistenciaEmployee.consultar();
	}

	public String editarEmployee(int employeeID) {

		persistenciaEmployee = new PersistenciaEmployee();

		employee = persistenciaEmployee.pesquisar(employeeID);

		return "atualizar";
	}

	public String confirmarAtualizacao() {

		return "confirmarAtualizacao";
	}

	public String atualizar() {

		persistenciaEmployee = new PersistenciaEmployee();

		persistenciaEmployee.atualizar(employee);

		return "mostrarAtualizacao";
	}

	public String excluirEmployee(int employeeID) {

		persistenciaEmployee = new PersistenciaEmployee();

		employee = persistenciaEmployee.pesquisar(employeeID);

		return "confirmarExclusao";

	}

	public String excluir() {

		persistenciaEmployee = new PersistenciaEmployee();

		persistenciaEmployee.excluir(employee);

		return "mostrarExclusao";
	}

	public String pesquisar(String nome) {

		System.out.println("\n Nome: " + nome);

		persistenciaEmployee = new PersistenciaEmployee();

		resultado = persistenciaEmployee.pesquisar(nome);

		return "mostrarPesquisa";
	}

	public String novo() {

		employee = new Employee();

		return "homepage";
	}

}
