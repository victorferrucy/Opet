/**
 * 
 */
package softhair.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import softhair.model.Cliente;
import softhair.model.dao.ClienteDao;

/**
 * @author Victor Ferrucy
 *
 */

@FacesConverter(value = "clienteConverter")
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idCliente) {
		if (!idCliente.isEmpty() && idCliente != null) {
			ClienteDao clienteDao = new ClienteDao();
			return clienteDao.buscarPorId(Integer.valueOf(idCliente));
		}
		return new Cliente();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object clienteObject) {
		if (clienteObject != null && clienteObject instanceof Cliente) {
			Cliente cliente = (Cliente) clienteObject;
			return String.valueOf(cliente.getIdColaborador());

		}
		return "";
	}

}
