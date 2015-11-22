/**
 * 
 */
package softhair.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import softhair.model.Servico;
import softhair.model.dao.ServicoDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
@ManagedBean
@SessionScoped
public class ServicoController {

	private Servico servico;
	private List<Servico> servicos;
	private ServicoDao servicoDao;

	public ServicoController() {
		servico = new Servico();
		servicoDao = new ServicoDao();
	}

	public String paginaInicial() {
		return "telaInicial.xhtml?faces-redirect=true";
	}

	public String novoServico() {
		servico = new Servico();
		return "cadastrarServico.xhtml?faces-redirect=true";
	}

	public String atualizarServico(Servico servico) {
		this.servico = servico;
		return "alterarServico.xhtml?faces-redirect=true";
	}

	public String visualizarServico(Servico servico) {
		this.servico = servico;
		return "visualizarServico.xhtml?faces-redirect=true";
	}

	public String voltarPagina() {
		return "telaInicial.xhtml?faces-redirect=true";
	}

	public void salvar() {
		servicoDao.salvar(servico);
		servico = new Servico();
	}

	public void atualizar(Servico servico) {
		servicoDao.atualizar(servico);

	}

	public List<Servico> buscar() {
		servicos = new ArrayList<Servico>();
		servicos = servicoDao.buscar();

		return servicos;
	}

	public void deletar(Servico servico) {
		servicoDao.deletar(servico);
	}

	/**
	 * @return the servico
	 */
	public Servico getServico() {
		return servico;
	}

	/**
	 * @param servico
	 *            the servico to set
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}

	/**
	 * @return the servicos
	 */
	public List<Servico> getServicos() {
		return servicos;
	}

	/**
	 * @param servicos
	 *            the servicos to set
	 */
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	/**
	 * @return the servicoDao
	 */
	public ServicoDao getServicoDao() {
		return servicoDao;
	}

	/**
	 * @param servicoDao
	 *            the servicoDao to set
	 */
	public void setServicoDao(ServicoDao servicoDao) {
		this.servicoDao = servicoDao;
	}

}
