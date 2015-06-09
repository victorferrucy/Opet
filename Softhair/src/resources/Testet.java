/**
 * 
 */
package resources;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Victor Ferrucy
 *
 */
@SessionScoped
@Named
@Model

public class Testet implements Serializable {
	
	private static final long serialVersionUID = 7250140514690315891L;
	
	private boolean batata;

	/**
	 * @return the batata
	 */
	public boolean isBatata() {
		return batata;
	}

	/**
	 * @param teste the teste to set
	 */
	public void setBatata(boolean batata) {
		this.batata = batata;
	}
	
	
}
