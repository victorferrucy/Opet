package softhair.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Victor Ferrucy
 * @since 18/06/2015
 * @version 0.01
 */
@Entity
@Table
public class Agenda {
	@Id @GeneratedValue
	private Cliente cliente;
	private Funcionario funcionario;
	private Date dataReserva;
}
