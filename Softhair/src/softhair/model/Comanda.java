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
import javax.persistence.PrimaryKeyJoinColumn;
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
	@ManyToOne @PrimaryKeyJoinColumn
	private Cliente cliente;
	@ManyToMany @PrimaryKeyJoinColumn
	private List<Funcionario> funcionarios;
	@ManyToMany @PrimaryKeyJoinColumn
	private List<Servico> servicos;
	@Column @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataAbertura;
	@Column
	private Date dataFechamento;
	@Column
	private BigDecimal total;
	@Column
	private String status;
	
}
