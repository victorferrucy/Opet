/**
 * 
 */
package softhair.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName = Contato.CONTATO_SEQUENCE, name = Contato.CONTATO_SEQUENCE, initialValue = 0, allocationSize = 5)
public class Contato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6041638752094878377L;

	public static final String CONTATO_SEQUENCE = "contato_sequence";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CONTATO_SEQUENCE)
	private int idContato;
	@Column
	private String emailPrincipal;
	@Column
	private String emailSecundario;
	@Column
	private String telefoneResidencial;
	@Column
	private String telefoneComercial;
	@Column
	private String celular;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((emailPrincipal == null) ? 0 : emailPrincipal.hashCode());
		result = prime * result + ((emailSecundario == null) ? 0 : emailSecundario.hashCode());
		result = prime * result + idContato;
		result = prime * result + ((telefoneComercial == null) ? 0 : telefoneComercial.hashCode());
		result = prime * result + ((telefoneResidencial == null) ? 0 : telefoneResidencial.hashCode());
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
		Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (emailPrincipal == null) {
			if (other.emailPrincipal != null)
				return false;
		} else if (!emailPrincipal.equals(other.emailPrincipal))
			return false;
		if (emailSecundario == null) {
			if (other.emailSecundario != null)
				return false;
		} else if (!emailSecundario.equals(other.emailSecundario))
			return false;
		if (idContato != other.idContato)
			return false;
		if (telefoneComercial == null) {
			if (other.telefoneComercial != null)
				return false;
		} else if (!telefoneComercial.equals(other.telefoneComercial))
			return false;
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null)
				return false;
		} else if (!telefoneResidencial.equals(other.telefoneResidencial))
			return false;
		return true;
	}
	/**
	 * @return the emailPrincipal
	 */
	public String getEmailPrincipal() {
		return emailPrincipal;
	}
	/**
	 * @param emailPrincipal the emailPrincipal to set
	 */
	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}
	/**
	 * @return the emailSecundario
	 */
	public String getEmailSecundario() {
		return emailSecundario;
	}
	/**
	 * @param emailSecundario the emailSecundario to set
	 */
	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}
	/**
	 * @return the telefoneResidencial
	 */
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	/**
	 * @param telefoneResidencial the telefoneResidencial to set
	 */
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	/**
	 * @return the telefoneComercial
	 */
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	/**
	 * @param telefoneComercial the telefoneComercial to set
	 */
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	/**
	 * @return the idContato
	 */
	public int getIdContato() {
		return idContato;
	}
}
