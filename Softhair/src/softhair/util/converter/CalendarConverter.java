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
@FacesConverter("calendarConverter")
public class CalendarConverter implements Converter{
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Calendar calendar = Calendar.getInstance(new Locale("pr", "BR"));
		
		try {
			calendar.setTime(sdf.parse(arg2));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Calendar calendar = ((Calendar)arg2).getInstance(new Locale("pt", "BR"));
		
		return sdf.format(calendar.getTime());
	}

}
