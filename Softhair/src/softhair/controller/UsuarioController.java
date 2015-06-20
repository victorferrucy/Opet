/**
 * 
 */
package softhair.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import softhair.model.Usuario;
import softhair.model.dao.UsuarioDao;

/**
 * @author Victor Ferrucy
 *
 */
@ManagedBean
@SessionScoped
public class UsuarioController {
	private Usuario usuario;
	private UsuarioDao usuarioDao;
	
	public UsuarioController(){
		usuario = new Usuario();
		usuarioDao = new UsuarioDao();
	}
	
	public Usuario buscarUsuario(Usuario usuario) {
		return usuario;

	}

	public String validarUsuario() {
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
			return "/agenda/agenda.xhtml?faces-redirect=true";
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

	/**
	 * @return the usuarioDao
	 */
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
