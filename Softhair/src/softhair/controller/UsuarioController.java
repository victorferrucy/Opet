/**
 * 
 */
package softhair.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import softhair.model.Usuario;

/**
 * @author Victor Ferrucy
 *
 */
@ManagedBean
@SessionScoped
public class UsuarioController {
	private Usuario usuario;

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authManager;
	
	public UsuarioController() {
		usuario = new Usuario();
	}

	public String login() {
		try {
			
			System.out.println("USUARIO " + usuario.getLogin() + "  " + usuario.getSenha());
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					usuario.getLogin(), usuario.getSenha());
			Authentication authenticate = authManager.authenticate(usernamePasswordAuthenticationToken);	
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			System.out.println("CORRETO");
			return "correct";
		} catch (final Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Invalid login", "Bad Credential. Try again"));
		}
		System.out.println("DEU RUIM");
		return null;
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		usuario = new Usuario();
		return "logout";
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the authManager
	 */
	public AuthenticationManager getAuthManager() {
		return authManager;
	}

	/**
	 * @param authManager the authManager to set
	 */
	public void setAuthManager(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

}
