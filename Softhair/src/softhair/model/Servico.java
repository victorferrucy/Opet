package softhair.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
public class Servico {
	@Id @GeneratedValue
	private int idServico;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private BigDecimal comissao;
	@Column
	private BigDecimal valor;
	
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the comissao
	 */
	public BigDecimal getComissao() {
		return comissao;
	}
	/**
	 * @param comissao the comissao to set
	 */
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	/**
	 * @return the idServico
	 */
	public int getIdServico() {
		return idServico;
	}
}
