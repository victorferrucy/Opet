/**
 * 
 */
package softhair.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import softhair.model.CargoSistema;
import softhair.model.Usuario;
import softhair.model.dao.UsuarioDao;

/**
 * @author Victor Ferrucy
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioController {
	private Usuario usuarioC;
	private List<Usuario> usuarios;
	private UsuarioDao usuarioDao;
	private List<CargoSistema> cargos;
	private CargoSistema cargo;

	public UsuarioController() {
		usuarioC = new Usuario();
		usuarioDao = new UsuarioDao();
		usuarios = usuarioDao.buscar();
		cargos = usuarioDao.buscarCargos();
		cargo = new CargoSistema();
	}

	public void novoUsuario() {

		FacesContext fc = FacesContext.getCurrentInstance();
		usuarioC.getCargo().add(cargo);
		usuarioDao.salvar(usuarioC);
		usuarioC = new Usuario();
		usuarios = usuarioDao.buscar();

		fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
	}

	public void atualizarUsuario(Usuario usuario) {
		FacesContext fc = FacesContext.getCurrentInstance();
		usuarioC = usuario;

		fc.addMessage(null, new FacesMessage("Atualizado com sucesso!"));
	}

	public void deletarUsuario(Usuario usuario) {
		FacesContext fc = FacesContext.getCurrentInstance();
		usuarioDao.deletar(usuario);
		usuarios = usuarioDao.buscar();

		fc.addMessage(null, new FacesMessage("Deletado com sucesso!"));
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuarioC() {
		return usuarioC;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuarioC(Usuario usuarioC) {
		this.usuarioC = usuarioC;
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the cargos
	 */
	public List<CargoSistema> getCargos() {
		return cargos;
	}

	/**
	 * @param cargos
	 *            the cargos to set
	 */
	public void setCargos(List<CargoSistema> cargos) {
		this.cargos = cargos;
	}

	/**
	 * @return the cargo
	 */
	public CargoSistema getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(CargoSistema cargo) {
		this.cargo = cargo;
	}

}
