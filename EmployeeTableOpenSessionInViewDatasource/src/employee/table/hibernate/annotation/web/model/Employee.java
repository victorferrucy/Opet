package employee.table.hibernate.annotation.web.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 */

/**
 * Classe para representar um empregado.
 * 
 * @author Baracho
 * 
 * @since 14/05/2013
 * 
 * @version 2.0
 * 
 *          Acessado em 2013 Maio 14
 *          http://stackoverflow.com/questions/3068692/hibernate
 *          -sequence-on-oracle-generatedvaluestrategy-generationtype-auto
 * 
 */
@Entity
@Table(name = "EMPLOYEE_TABLE")
public class Employee implements Serializable {

	// Variáveis de instância

	/**
	 * 
	 */
	private static final long serialVersionUID = -5658761488022674063L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "entity_sequence_generator")
	@SequenceGenerator(name = "entity_sequence_generator", sequenceName = "EMPLOYEE_SEQUENCE")
	@Column(name = "Employee_ID", nullable = false)
	private int employeeID;

	@Column(name = "First_Name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "Last_Name", length = 50, nullable = true)
	private String lastName;

	@Column(name = "DATE_HIRE", nullable = true)
	private Date dataContratacao;

	// Função Construtora da classe.

	public Employee() {

	}

	public Employee(String firstName, String lastName, Date dataContratacao) {

		setEmployeeID(employeeID);
		setFirstName(firstName);
		setLastName(lastName);
		setDataContratacao(dataContratacao);

	}

	// Métodos de acesso

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName.toUpperCase();
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		if (lastName == null) {

			this.lastName = null;

		} else {

			this.lastName = lastName.toUpperCase();

		}
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	// Métodos da classe

	@Override
	public String toString() {
		
		// Declaração de variáveis

		String saida = null;
		
		final String ERROR_ACTION = "VALOR INVÁLIDO OU NÃO INFORMADO.";
		
		// Processamento dosa dados

		saida = "\n Employee ID: " + employeeID;

		saida += "\n First Name: " + firstName;

		saida += "\n Last Name: ";

		if (lastName != null) {

			saida += lastName;

		} else {

			saida += ERROR_ACTION;
		}

		saida += "\n Data de Contratação: ";

		if (dataContratacao != null) {

			saida += new SimpleDateFormat("dd/MM/yyyy").format(dataContratacao);

		} else {

			saida += ERROR_ACTION;
		}
		
		// Retorno do método

		return saida;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataContratacao == null) ? 0 : dataContratacao.hashCode());
		result = prime * result + employeeID;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (dataContratacao == null) {
			if (other.dataContratacao != null) {
				return false;
			}
		} else if (!dataContratacao.equals(other.dataContratacao)) {
			return false;
		}
		if (employeeID != other.employeeID) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}

}
