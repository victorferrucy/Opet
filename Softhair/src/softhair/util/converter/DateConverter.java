/**
 * 
 */
package softhair.util.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Victor Ferrucy
 *
 */
@FacesConverter("dateConverter")
public class DateConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(arg2);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
		try {
			calendar.setTime(sdf.parse(arg2));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		return arg2.toString();
	}

}
