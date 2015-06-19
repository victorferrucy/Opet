/**
 * 
 */
package employee.table.hibernate.annotation.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Backing Bean para realizar a conversão entre uma data e uma string.
 * 
 * @author Baracho
 * 
 * @since 23/09/2013
 * 
 * @version 1.0
 * 
 */

@FacesConverter("employee.table.util.ConverterDate")
public class ConverterDate implements Converter {

	/**
	 * 
	 */
	public ConverterDate() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// TODO Auto-generated method stub

		Date data = null;

		DateFormat formatdor = new SimpleDateFormat("dd/MM/yyyy");

		try {

			data = formatdor.parse(value);

		} catch (ParseException e) {
			// TODO: handle exception

			data = null;
		}

		if (data != null) {

			return new java.sql.Date(data.getTime());

		} else {

			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		// TODO Auto-generated method stub

		java.sql.Date data = (java.sql.Date) value;

		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}

}
