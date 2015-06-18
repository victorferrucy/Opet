/**
 * 
 */
package softhair.model;

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
	private String emailPrincipal;
	private String emailSecundario;
	private String telefoneResidencial;
	private String telefoneComercial;
	private String celular;
}
