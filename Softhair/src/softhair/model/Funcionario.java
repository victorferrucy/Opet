package softhair.model;

import java.io.Serializable;
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
public class Funcionario extends Colaborador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6180694912130094414L;
	
	@Column
	private Calendar dataContratacao;
	@Column
	private Calendar dataDemissao;
	@Column(precision = 2)
	private BigDecimal salario;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataContratacao == null) ? 0 : dataContratacao.hashCode());
		result = prime * result + ((dataDemissao == null) ? 0 : dataDemissao.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (dataContratacao == null) {
			if (other.dataContratacao != null)
				return false;
		} else if (!dataContratacao.equals(other.dataContratacao))
			return false;
		if (dataDemissao == null) {
			if (other.dataDemissao != null)
				return false;
		} else if (!dataDemissao.equals(other.dataDemissao))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
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
