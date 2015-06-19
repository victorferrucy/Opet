package softhair.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
public class Servico {
	@Id @GeneratedValue
	private int idServico;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private BigDecimal comissao;
	@Column
	private BigDecimal valor;
}
