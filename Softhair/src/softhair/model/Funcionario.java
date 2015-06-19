/**
 * 
 */
package softhair.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@PrimaryKeyJoinColumn(name="idColaborador")
public class Funcionario extends Colaborador {
	private Date dataContratacao;
	private Date dataDemissao;
	private BigDecimal salario;
}
