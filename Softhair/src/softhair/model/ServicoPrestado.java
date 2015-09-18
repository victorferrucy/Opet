/**
 * 
 */
package softhair.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName = ServicoPrestado.SERVICO_PRESTADO_SEQUENCE, name = ServicoPrestado.SERVICO_PRESTADO_SEQUENCE, initialValue = 0, allocationSize = 5)
public class ServicoPrestado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1101307507987913512L;
	
	public static final String SERVICO_PRESTADO_SEQUENCE = "servico_prestado_sequence";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SERVICO_PRESTADO_SEQUENCE)
	private Integer idServicoPrestado;
	@OneToOne @JoinColumn(name="idFuncionario")
	private Funcionario funcionario;
	@OneToOne @JoinColumn(name="idServico")
	private Servico servico;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((idServicoPrestado == null) ? 0 : idServicoPrestado.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoPrestado other = (ServicoPrestado) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (idServicoPrestado == null) {
			if (other.idServicoPrestado != null)
				return false;
		} else if (!idServicoPrestado.equals(other.idServicoPrestado))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}
	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	/**
	 * @return the servico
	 */
	public Servico getServico() {
		return servico;
	}
	/**
	 * @param servico the servico to set
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	/**
	 * @return the idServicoPrestado
	 */
	public Integer getIdServicoPrestado() {
		return idServicoPrestado;
	}
	
}
