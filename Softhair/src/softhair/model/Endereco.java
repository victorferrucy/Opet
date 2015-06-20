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
	
	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the idEndereco
	 */
	public int getIdEndereco() {
		return idEndereco;
	}
}
