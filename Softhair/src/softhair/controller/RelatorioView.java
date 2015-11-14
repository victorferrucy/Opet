/**
 * 
 */
package softhair.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

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

	public RelatorioView() {
		// Receita
		comandaDao = new ComandaDao();
		dataInicial = Calendar.getInstance();
		dataFinal = Calendar.getInstance();
		dataFinal.set(Calendar.MONTH, dataFinal.get(Calendar.MONTH) + 1);
		receitaMensal = comandaDao.buscarReceitaPeriodo(dataInicial, dataFinal);

		// Comissao
		servicoPrestadoDao = new ServicoPrestadoDao();
		funcionarioDao = new FuncionarioDao();
		funcionarios = funcionarioDao.buscar();
		comissao = new BigDecimal("0.00");

	}

	public void calcularReceitaMensal() {
		receitaMensal = comandaDao.buscarReceitaPeriodo(dataInicial, dataFinal);

		if (receitaMensal == null) {
			System.out.println("null RECEIETA");
			receitaMensal = new BigDecimal("0.00");
		}
	}

	public void calcularComissaoFuncionario() {
		List<ServicoPrestado> servicosPrestadosFuncionario;
		servicosPrestadosFuncionario = servicoPrestadoDao
				.buscarServicosPrestadosFuncionario(funcionario.getIdColaborador(), dataInicial, dataFinal);

		comissao = new BigDecimal("0.00");

		for (ServicoPrestado sp : servicosPrestadosFuncionario) {
			System.out.println("ID SERVIÇo " + sp.getIdServicoPrestado());
			comissao = comissao.add(sp.getServico().getValor().multiply(sp.getServico().getComissao()));
		}
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

}
