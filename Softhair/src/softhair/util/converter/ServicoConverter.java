/**
 * 
 */
package softhair.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import softhair.model.Servico;
import softhair.model.dao.ServicoDao;

/**
 * @author Victor Ferrucy
 *
 */

@FacesConverter(value="servicoConverter")
public class ServicoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idServico) {
		ServicoDao servicoDao = new ServicoDao();
		
		return 	servicoDao.buscarPorId(Integer.parseInt(idServico));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object servicoObject) {
		
		if(servicoObject != null && servicoObject instanceof Servico){
			Servico servico = (Servico)servicoObject;
			return String.valueOf(servico.getIdServico());
		}
		
		return "";
	}
	
}
