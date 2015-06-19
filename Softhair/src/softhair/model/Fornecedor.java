/**
 * 
 */
package softhair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
public class Fornecedor {
	@Id @GeneratedValue
	private int idFornecedor;
	@OneToOne @PrimaryKeyJoinColumn
	private Contato contato;
	@OneToOne @PrimaryKeyJoinColumn
	private Endereco endereco;
	@Column
	private String nome;
	@Column
	private String cnpj;
}
