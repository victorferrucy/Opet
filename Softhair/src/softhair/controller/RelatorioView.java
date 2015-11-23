/**
 * 
 */
package softhair.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import softhair.model.Funcionario;
import softhair.model.ServicoPrestado;
import softhair.model.dao.ComandaDao;
import softhair.model.dao.FuncionarioDao;
import softhair.model.dao.ServicoPrestadoDao;

/**
 * @author Victor Ferrucy
 *
 */
@ManagedBean(name = "relatorioview")
@ViewScoped
public class RelatorioView {

	private ComandaDao comandaDao;
	private BigDecimal receitaMensal;
	private Calendar dataInicial;
	private Calendar dataFinal;
	private Funcionario funcionario;
	private BigDecimal comissao;

	private ServicoPrestadoDao servicoPrestadoDao;
	private List<Funcionario> funcionarios;
	private FuncionarioDao funcionarioDao;

	private String msgReceita;
	private String msgComissao;
	private String valorFormatado;

	public RelatorioView() {
		setValorFormatado("");
		comandaDao = new ComandaDao();
		dataInicial = Calendar.getInstance();
		dataFinal = Calendar.getInstance();
		dataFinal.set(Calendar.MONTH, dataFinal.get(Calendar.MONTH) + 1);
		// Receita

		receitaMensal = comandaDao.buscarReceitaPeriodo(dataInicial, dataFinal);
		msgReceita = "";
		// Comissao
		servicoPrestadoDao = new ServicoPrestadoDao();
		funcionarioDao = new FuncionarioDao();
		funcionarios = funcionarioDao.buscar();
		comissao = new BigDecimal("0.00");
		msgComissao = "";

	}

	public void calcularReceitaMensal() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "BR"));

		receitaMensal = comandaDao.buscarReceitaPeriodo(dataInicial, dataFinal);

		setMsgReceita("A receita entre o período " + sdf.format(dataInicial.getTime()) + " e "
				+ sdf.format(dataFinal.getTime()) + " é de:");

		if (receitaMensal == null) {
			receitaMensal = new BigDecimal("0.00");
			setValorFormatado(nf.format(receitaMensal));
		} else {
			setValorFormatado(nf.format(receitaMensal));
		}
	}

	public void calcularComissaoFuncionario() {
		List<ServicoPrestado> servicosPrestadosFuncionario;
		servicosPrestadosFuncionario = servicoPrestadoDao
				.buscarServicosPrestadosFuncionario(funcionario.getIdColaborador(), dataInicial, dataFinal);

		comissao = new BigDecimal("0.00");

		for (ServicoPrestado sp : servicosPrestadosFuncionario) {
			BigDecimal valorComissao = new BigDecimal("0.00");
			valorComissao = sp.getServico().getValor()
					.multiply(sp.getServico().getComissao().divide(new BigDecimal("100")));
			comissao = comissao.add(valorComissao);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "BR"));

		setMsgComissao("A comissão do funcionário " + funcionario.getNome() + " entre o período "
				+ sdf.format(dataInicial.getTime()) + " e " + sdf.format(dataFinal.getTime()) + " é de:");
		valorFormatado = nf.format(comissao);

	}

	/**
	 * @return the receitaMensal
	 */
	public BigDecimal getReceitaMensal() {
		return receitaMensal;
	}

	/**
	 * @param receitaMensal
	 *            the receitaMensal to set
	 */
	public void setReceitaMensal(BigDecimal receitaMensal) {
		this.receitaMensal = receitaMensal;
	}

	/**
	 * @return the dataInicial
	 */
	public Calendar getDataInicial() {
		return dataInicial;
	}

	/**
	 * @param dataInicial
	 *            the dataInicial to set
	 */
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * @return the dataFinal
	 */
	public Calendar getDataFinal() {
		return dataFinal;
	}

	/**
	 * @param dataFinal
	 *            the dataFinal to set
	 */
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios
	 *            the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * @return the comissao
	 */
	public BigDecimal getComissao() {
		return comissao;
	}

	/**
	 * @param comissao
	 *            the comissao to set
	 */
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario
	 *            the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the msgReceita
	 */
	public String getMsgReceita() {
		return msgReceita;
	}

	/**
	 * @param msgReceita
	 *            the msgReceita to set
	 */
	public void setMsgReceita(String msgReceita) {
		this.msgReceita = msgReceita;
	}

	/**
	 * @return the msgComissao
	 */
	public String getMsgComissao() {
		return msgComissao;
	}

	/**
	 * @param msgComissao
	 *            the msgComissao to set
	 */
	public void setMsgComissao(String msgComissao) {
		this.msgComissao = msgComissao;
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

}
