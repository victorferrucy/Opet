/**
 * 
 */
package softhair.model;

import java.util.List;

/**
 * @author Victor Ferrucy
 *
 */
public enum Status {
	
	AGUARDANDO("Aguardando"),
	FINALIZADO("Finalizado"),
	EM_ATENDIMENTO("Em atendimento"),
	CANCELADO("Cancelado");
	
	private final String status;
	
	private Status (String status){
		this.status = status;
	}	
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
}
