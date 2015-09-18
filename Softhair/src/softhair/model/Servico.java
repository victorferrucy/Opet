package softhair.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName = Servico.SERVICO_SEQUENCE, name = Servico.SERVICO_SEQUENCE, initialValue = 0, allocationSize = 5)
public class Servico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2290793237661554870L;

	public static final String SERVICO_SEQUENCE = "servico_sequence";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SERVICO_SEQUENCE)
	private int idServico;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private BigDecimal comissao;
	@Column
	private BigDecimal valor;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comissao == null) ? 0 : comissao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idServico;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (comissao == null) {
			if (other.comissao != null)
				return false;
		} else if (!comissao.equals(other.comissao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idServico != other.idServico)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
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
