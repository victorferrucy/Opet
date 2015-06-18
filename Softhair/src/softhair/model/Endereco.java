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
public class Endereco {
	@Id @GeneratedValue
	private int idEndereco;
	@Column
	private String rua;
	@Column
	private String cep;
	@Column
	private String bairro;
	@Column
	private String numero;
	@Column
	private String complemento;
	@Column
	private String cidade;
	@Column
	private String estado;
	
}
