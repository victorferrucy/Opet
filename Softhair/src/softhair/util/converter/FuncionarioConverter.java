/**
 * 
 */
package softhair.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import softhair.model.Funcionario;
import softhair.model.dao.FuncionarioDao;

/**
 * @author Victor Ferrucy
 *
 */
@FacesConverter(value = "funcionarioConverter")
public class FuncionarioConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idFuncionario) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		System.out.println("ID FUNCIONARIO" + idFuncionario);
		return funcionarioDao.buscarPorId(Integer.parseInt(idFuncionario));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object funcionarioObject) {
		if (funcionarioObject != null && funcionarioObject instanceof Funcionario) {

			Funcionario funcionario = (Funcionario) funcionarioObject;

			return String.valueOf(funcionario.getIdColaborador());

		}

		return "";
	}

}
