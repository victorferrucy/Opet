/**
 * 
 */
package softhair.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@PrimaryKeyJoinColumn
public class Cliente extends Colaborador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5988439006526410448L;

	public Cliente() {
	}

	public Cliente(Integer idColaborador, Contato contato, Endereco endereco,
			String nome, String sobrenome, String cpf, String rg, String sexo,
			Calendar dataNascimento) {
		super(idColaborador, contato, endereco, nome, sobrenome, cpf, rg, sexo,
				dataNascimento);
		
	}
	
	
}
