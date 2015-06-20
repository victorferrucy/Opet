package softhair.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * 
 * @author Victor Ferrucy
 * @since 18/06/2015
 * @version 0.01
 */
@Entity
@Table
public class HorarioReservado {
	@Id @GeneratedValue
	private int idHorarioReservado;
	@ManyToOne @PrimaryKeyJoinColumn
	private Cliente cliente;
	@ManyToOne @PrimaryKeyJoinColumn
	private Funcionario funcionario;
	@Column
	private Calendar  dataInicio;
	@Column 
	private Calendar  dataFim;
	@Column
	private String descricao;
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
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	/**
	 * @return the dataInicio
	 */
	public Calendar getDataInicio() {
		return dataInicio;
	}
	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	/**
	 * @return the dataFim
	 */
	public Calendar getDataFim() {
		return dataFim;
	}
	/**
	 * @param dataFim the dataFim to set
	 */
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
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
	 * @return the idHorarioReservado
	 */
	public int getIdHorarioReservado() {
		return idHorarioReservado;
	}
	
}
