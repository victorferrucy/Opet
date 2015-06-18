/**
 * 
 */
package softhair.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @author Victor Ferrucy
 *
 */
public class Comanda {
	private Cliente cliente;
	private List<Funcionario> funcionarios;
	private List<Servico> servicos;
	private Date dataAbertura;
	private Date dataFechamento;
	private BigDecimal total;
	
}
