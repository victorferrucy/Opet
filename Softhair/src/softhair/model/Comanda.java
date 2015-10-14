/**
 * 
 */
package softhair.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName = Comanda.COMANDA_SEQUENCE, name = Comanda.COMANDA_SEQUENCE, initialValue = 0, allocationSize = 10)
public class Comanda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7425291224978913179L;

	public static final String COMANDA_SEQUENCE = "comanda_sequence";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = COMANDA_SEQUENCE)
	private int idComanda;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval= true)
	private List<ServicoPrestado> servicosPrestados;
	@Column
	private Calendar dataAbertura;
	@Column
	private Calendar dataFechamento;
	@Column
	private BigDecimal total;
	@Column
	private String status;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((dataFechamento == null) ? 0 : dataFechamento.hashCode());
		result = prime * result + idComanda;
		result = prime * result + ((servicosPrestados == null) ? 0 : servicosPrestados.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Comanda other = (Comanda) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataFechamento == null) {
			if (other.dataFechamento != null)
				return false;
		} else if (!dataFechamento.equals(other.dataFechamento))
			return false;
		if (idComanda != other.idComanda)
			return false;
		if (servicosPrestados == null) {
			if (other.servicosPrestados != null)
				return false;
		} else if (!servicosPrestados.equals(other.servicosPrestados))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the dataAbertura
	 */
	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	/**
	 * @param dataAbertura
	 *            the dataAbertura to set
	 */
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	/**
	 * @return the dataFechamento
	 */
	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	/**
	 * @param dataFechamento
	 *            the dataFechamento to set
	 */
	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the idComanda
	 */
	public int getIdComanda() {
		return idComanda;
	}

	/**
	 * @return the servicosPrestados
	 */
	public List<ServicoPrestado> getServicosPrestados() {
		return servicosPrestados;
	}

	/**
	 * @param servicosPrestados
	 *            the servicosPrestados to set
	 */
	public void setServicosPrestados(List<ServicoPrestado> servicosPrestados) {
		this.servicosPrestados = servicosPrestados;
	}
}
