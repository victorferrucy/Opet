/**
 * 
 */
package softhair.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table(appliesTo = "cliente" )
@PrimaryKeyJoinColumn(name="idColaborador")
public class Cliente extends Colaborador {
	
}
