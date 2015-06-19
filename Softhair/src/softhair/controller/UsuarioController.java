/**
 * 
 */
package softhair.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import softhair.model.Usuario;
import softhair.model.dao.UsuarioDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */

@ManagedBean
@SessionScoped
public class UsuarioController {
	private Usuario usuario;
	private UsuarioDao usuarioDao;

	public UsuarioController(){
		setUsuario(new Usuario());
	}
	
	public Usuario buscarUsuario(Usuario usuario) {
		usuarioDao = new UsuarioDao();
		
		return usuario;

	}

	public String validarUsuario(Usuario usuario) {
		/*Usuario usuarioLogando = this.buscarUsuario(usuario);
		if (usuarioLogando == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/agenda/agenda";
		}*/
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getSenha());
		if(usuario.getLogin().equals("victor") && usuario.getSenha().equals("victor")){
			System.out.println("ACHOOOO");
			return "/agenda/agenda";
			
		} else {
			System.out.println("NULL");
			return null;
		}
			
		
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
