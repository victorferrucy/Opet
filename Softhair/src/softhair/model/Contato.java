/**
 * 
 */
package softhair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
public class Contato {
	@Id @GeneratedValue
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
