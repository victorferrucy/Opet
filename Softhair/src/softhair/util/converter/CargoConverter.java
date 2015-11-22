/**
 * 
 */
package softhair.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import softhair.model.CargoSistema;
import softhair.model.Cliente;
import softhair.model.dao.UsuarioDao;

/**
 * @author Victor Ferrucy
 *
 */
@FacesConverter(value = "cargoConverter")
public class CargoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idCargo) {
		if (!idCargo.isEmpty() && idCargo != null) {
			UsuarioDao usuarioDao = new UsuarioDao();
			return usuarioDao.buscarCargo(Integer.valueOf(idCargo));
		}
		return new Cliente();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object cargoObject) {
		if (cargoObject != null && cargoObject instanceof CargoSistema) {
			CargoSistema cargo = (CargoSistema) cargoObject;
			return String.valueOf(cargo.getIdCargoSistema());
		}
		return "";
	}

}
