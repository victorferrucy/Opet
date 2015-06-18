/**
 * 
 */
package softhair.model;

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
public class Cliente extends Colaborador {
	
}
