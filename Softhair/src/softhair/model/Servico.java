package softhair.model;

import java.math.BigDecimal;

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
	private String nome;
	private String descricao;
	private BigDecimal comissao;
	private BigDecimal valor;
}
