/**
 * 
 */
package softhair.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@PrimaryKeyJoinColumn
public class Cliente extends Colaborador {
	public Cliente() {
	}

	public Cliente(int idColaborador, Contato contato, Endereco endereco,
			String nome, String sobrenome, String cpf, String rg, String sexo,
			Calendar dataNascimento) {
		super(idColaborador, contato, endereco, nome, sobrenome, cpf, rg, sexo,
				dataNascimento);
		
	}
}
