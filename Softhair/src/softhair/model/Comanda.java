/**
 * 
 */
package softhair.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
public class Comanda {
	@Id @GeneratedValue
	private int idComanda;
	@ManyToOne @JoinColumn(name="idCliente")
	private Cliente cliente;
	@ManyToMany @JoinColumn(name="idFuncionario")
	private List<Funcionario> funcionarios;
	@ManyToMany @JoinColumn(name="idServico")
	private List<Servico> servicos;
	@Column @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataAbertura;
	@Column
	private Date dataFechamento;
	@Column
	private BigDecimal total;
	@Column
	private String status;
	
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	/**
	 * @return the servicos
	 */
	public List<Servico> getServicos() {
		return servicos;
	}
	/**
	 * @param servicos the servicos to set
	 */
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	/**
	 * @return the dataAbertura
	 */
	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}
	/**
	 * @param dataAbertura the dataAbertura to set
	 */
	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	/**
	 * @return the dataFechamento
	 */
	public Date getDataFechamento() {
		return dataFechamento;
	}
	/**
	 * @param dataFechamento the dataFechamento to set
	 */
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
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
	 * @param status the status to set
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
}
