/**
 * 
 */
package softhair.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * @author Victor Ferrucy
 *
 */
@Entity
@PrimaryKeyJoinColumn
public class Cliente extends Colaborador {
	
}
