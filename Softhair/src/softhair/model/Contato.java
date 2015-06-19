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
}
