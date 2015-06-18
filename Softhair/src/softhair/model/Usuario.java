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
public class Usuario {
	@Id @GeneratedValue
	private int idUsuario;
	private Funcionario funcionario;
	private String login;
	private String senha;
}
