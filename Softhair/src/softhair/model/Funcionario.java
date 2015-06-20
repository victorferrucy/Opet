package softhair.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 * @author Victor Ferrucy
 *
 */
@Entity
@PrimaryKeyJoinColumn
public class Funcionario extends Colaborador {
	@Column
	private Calendar dataContratacao;
	@Column
	private Calendar dataDemissao;
	@Column(precision = 2)
	private BigDecimal salario;
	/**
	 * @return the dataContratacao
	 */
	public Calendar getDataContratacao() {
		return dataContratacao;
	}
	/**
	 * @param dataContratacao the dataContratacao to set
	 */
	public void setDataContratacao(Calendar dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	/**
	 * @return the dataDemissao
	 */
	public Calendar getDataDemissao() {
		return dataDemissao;
	}
	/**
	 * @param dataDemissao the dataDemissao to set
	 */
	public void setDataDemissao(Calendar dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	/**
	 * @return the salario
	 */
	public BigDecimal getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
}
