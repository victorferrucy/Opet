/**
 * 
 */
package employee.table.hibernate.annotation.web.util;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Classe Backing Bean para determinar a localização do país.
 * 
 * @author Baracho
 * 
 * @since 31/03/2013
 * 
 * @version 1.0
 * 
 * 
 */

@Named("modificadorDeLocalizacao")
@ApplicationScoped
public class ModificadorDeLocalizacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888475108870397566L;

	/**
	 * 
	 */

	public ModificadorDeLocalizacao() {
		// TODO Auto-generated constructor stub
	}

	// Métodos da classe

	public String englandAction() {

		FacesContext context = FacesContext.getCurrentInstance();

		context.getViewRoot().setLocale(new Locale("en", "GB"));

		return null;
	}

	public String brazilAction() {

		FacesContext context = FacesContext.getCurrentInstance();

		context.getViewRoot().setLocale(new Locale("pt", "BR"));

		return null;
	}

	public String germanyAction() {

		FacesContext context = FacesContext.getCurrentInstance();

		context.getViewRoot().setLocale(new Locale("de", "DE"));

		return null;
	}

	public String usaAction() {

		FacesContext context = FacesContext.getCurrentInstance();

		context.getViewRoot().setLocale(new Locale("en", "US"));

		return null;
	}

}
