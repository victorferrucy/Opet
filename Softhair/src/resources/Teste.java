/**
 * 
 */
package resources;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
/**
 * @author Victor Ferrucy
 *
 */
public class Teste implements Serializable {
	
	private static final long serialVersionUID = 7568832480683878625L;
	
	private @Inject Testet tes;

	public Teste() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the tes
	 */
	public Testet getTes() {
		return tes;
	}
	/**
	 * @param tes the tes to set
	 */
	public void setTes(Testet tes) {
		this.tes = tes;
	}

	public void setBatata(boolean batata)
	{
		tes.setBatata(batata);
		
	}
}
