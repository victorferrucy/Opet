/**
 * 
 */
package softhair.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import softhair.model.Colaborador;
import softhair.model.Contato;
import softhair.model.Endereco;
import softhair.model.dao.ColaboradorDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
@ManagedBean
@SessionScoped
public class ColaboradorController {
	private Colaborador colaborador;
	private List<Colaborador> colaboradores;
	private ColaboradorDao colaboradorDao;
	private Contato contato;
	private Endereco endereco;
	
	public ColaboradorController(){
		setColaborador(new Colaborador());
		colaborador.setEndereco(new Endereco());
		colaborador.setContato(new Contato());
		setColaboradorDao(new ColaboradorDao());
		
	}
	
	public void salvar() {
		colaborador.setContato(contato);
		colaborador.setEndereco(endereco);
		colaboradorDao.salvar(colaborador);

	}

	public void atualizar(Colaborador colaborador) {

		colaboradorDao.atualizar(colaborador);

	}

	public List<Colaborador> buscar() {
		colaboradores = new ArrayList<Colaborador>();
		colaboradores = colaboradorDao.buscar();
		
		return colaboradores;
	}

	public void deletar(Colaborador colaborador) {

		colaboradorDao.deletar(colaborador);

	}
	/**
	 * @return the colaborador
	 */
	public Colaborador getColaborador() {
		return colaborador;
	}
	/**
	 * @param colaborador the colaborador to set
	 */
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	/**
	 * @return the colaboradores
	 */
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	/**
	 * @param colaboradores the colaboradores to set
	 */
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	/**
	 * @return the colaboradorDao
	 */
	public ColaboradorDao getColaboradorDao() {
		return colaboradorDao;
	}
	/**
	 * @param colaboradorDao the colaboradorDao to set
	 */
	public void setColaboradorDao(ColaboradorDao colaboradorDao) {
		this.colaboradorDao = colaboradorDao;
	}
	
	
}
