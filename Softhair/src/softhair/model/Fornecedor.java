/**
 * 
 */
package softhair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@OneToOne @JoinColumn(name="idContato")
	private Contato contato;
	@OneToOne @JoinColumn(name="idEndereco")
	private Endereco endereco;
	@Column
	private String nome;
	@Column
	private String cnpj;
	
	/**
	 * @return the contato
	 */
	public Contato getContato() {
		return contato;
	}
	/**
	 * @param contato the contato to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * @return the idFornecedor
	 */
	public int getIdFornecedor() {
		return idFornecedor;
	}
}
