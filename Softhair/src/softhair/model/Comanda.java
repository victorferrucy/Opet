/**
 * 
 */
package softhair.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

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
public class Comanda {
	@Id @GeneratedValue
	private Cliente cliente;
	private List<Funcionario> funcionarios;
	private List<Servico> servicos;
	private Date dataAbertura;
	private Date dataFechamento;
	private BigDecimal total;
	
}
