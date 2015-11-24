/**
 * 
 */
package softhair.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

	private String valorFormatado;
	private String comissaoFormatado;

	public ServicoController() {
		servico = new Servico();
		servicoDao = new ServicoDao();
	}

	public String paginaInicial() {
		return "telaInicial.xhtml?faces-redirect=true";
	}

	public void novoServico() {
		servico = new Servico();
	}

	public void atualizarServico(Servico servico) {
		this.servico = servico;
	}

	public void visualizarServico(Servico servico) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "BR"));
		NumberFormat nfp = new DecimalFormat("0.##%", DecimalFormatSymbols.getInstance(new Locale("PT", "BR")));
		this.servico = servico;

		valorFormatado = nf.format(servico.getValor());
		comissaoFormatado = nfp.format(servico.getComissao().divide(new BigDecimal("100")));

	}

	public String formatarComissao(BigDecimal comissao) {

		NumberFormat nfp = new DecimalFormat("0.##%", DecimalFormatSymbols.getInstance(new Locale("PT", "BR")));
		comissaoFormatado = nfp.format(comissao.divide(new BigDecimal("100")));
		return comissaoFormatado;
	}

	public String formatarValor(BigDecimal valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "BR"));
		valorFormatado = nf.format(valor.doubleValue());
		return valorFormatado;
	}

	public String voltarPagina() {
		return "telaInicial.xhtml?faces-redirect=true";
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		servicoDao.salvar(servico);
		servico = new Servico();
		fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
	}

	public void atualizar(Servico servico) {
		FacesContext fc = FacesContext.getCurrentInstance();
		servicoDao.atualizar(servico);
		fc.addMessage(null, new FacesMessage("Atualizado com sucesso!"));
	}

	public List<Servico> buscar() {
		servicos = new ArrayList<Servico>();
		servicos = servicoDao.buscar();

		return servicos;
	}

	public void deletar(Servico servico) {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		boolean deletou;
		
		deletou = servicoDao.deletar(servico);
		
		if(deletou){
			fc.addMessage(null, new FacesMessage("Deletado com sucesso!"));
		} else {
			fc.addMessage(null, new FacesMessage("Este serviço está sendo usado em uma comanda!"));
		}
		
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

	/**
	 * @return the valorFormatado
	 */
	public String getValorFormatado() {
		return valorFormatado;
	}

	/**
	 * @param valorFormatado
	 *            the valorFormatado to set
	 */
	public void setValorFormatado(String valorFormatado) {
		this.valorFormatado = valorFormatado;
	}

	/**
	 * @return the comissaoFormatado
	 */
	public String getComissaoFormatado() {
		return comissaoFormatado;
	}

	/**
	 * @param comissaoFormatado
	 *            the comissaoFormatado to set
	 */
	public void setComissaoFormatado(String comissaoFormatado) {
		this.comissaoFormatado = comissaoFormatado;
	}

}
