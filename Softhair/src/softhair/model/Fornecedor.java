/**
 * 
 */
package softhair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private Contato contato;
	private Endereco endereco;
	private String nome;
	private String cnpj;
}
