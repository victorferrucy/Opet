/**
 * 
 */
package softhair.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import softhair.model.Cliente;
import softhair.model.Comanda;
import softhair.model.Funcionario;
import softhair.model.Servico;
import softhair.model.ServicoPrestado;
import softhair.model.dao.ClienteDao;
import softhair.model.dao.ComandaDao;
import softhair.model.dao.FuncionarioDao;
import softhair.model.dao.ServicoDao;
import softhair.util.Status;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
@ManagedBean
@SessionScoped
public class ComandaController {
	private Comanda comanda;
	private Cliente cliente;
	private ServicoPrestado servicoPrestado;
	private List<ServicoPrestado> servicosPrestados;
	private List<Comanda> comandas;

	/* private Set<Comanda> comandas; */

	private ClienteDao clienteDao;
	private ComandaDao comandaDao;

	private Funcionario funcionario;
	private Servico servico;
	private List<Funcionario> funcionarios;
	private List<Servico> servicos;
	private List<Cliente> clientes;
	private List<Status> status;
	private List<String> nomeStatus;

	private ServicoDao servicoDao;
	private FuncionarioDao funcionarioDao;

	public ComandaController() {
		comanda = new Comanda();
		cliente = new Cliente();
		servicoPrestado = new ServicoPrestado();

		clienteDao = new ClienteDao();
		comandaDao = new ComandaDao();
		servicoDao = new ServicoDao();
		funcionarioDao = new FuncionarioDao();

		servicosPrestados = new ArrayList<ServicoPrestado>();
		funcionarios = funcionarioDao.buscar();
		servicos = servicoDao.buscar();
		clientes = clienteDao.buscar();
		comandas = comandaDao.buscar();

		status = Arrays.asList(Status.values());
		nomeStatus = new ArrayList<String>();
		for (Status s : status) {
			nomeStatus.add(s.getStatus());
		}
	}

	public String novaComanda() {
		comanda = new Comanda();
		servicosPrestados = new ArrayList<ServicoPrestado>();
		return "visualizarComanda.xhtml?faces-redirect=true";
	}

	public String visualizarComanda(Comanda comanda) {
		this.comanda = comanda;
		servicosPrestados = comanda.getServicosPrestados();
		return "visualizarComanda.xhtml?faces-redirect=true";
	}

	public void salvar(AjaxBehaviorEvent e) {
		if (comanda.getIdComanda() == 0) {
			comandaDao.salvar(comanda);
			comandas = comandaDao.buscar();
		}
	}

	public void atualizar(Comanda comanda) {
		comanda.setServicosPrestados(servicosPrestados);
		comandaDao.atualizar(comanda);
		comandas = comandaDao.buscar();
	}

	public List<Comanda> buscar() {
		comandas = new ArrayList<Comanda>();
		comandas = comandaDao.buscar();

		return comandas;
	}

	public List<Comanda> deletar(Comanda comandaSel) {
		boolean deletou = false;

		deletou = comandaDao.deletar(comandaDao.buscar(comandaSel));

		if (deletou) {
			comandas = comandaDao.buscar();
		}
		return comandas;
	}

	public List<ServicoPrestado> adicionarServico() {
		servicosPrestados.add(servicoPrestado);
		servicoPrestado = new ServicoPrestado();
		comanda.setTotal(totalComanda());
		return servicosPrestados;

	}

	public List<ServicoPrestado> removerServico(ServicoPrestado servicoPrestado) {
		servicosPrestados.remove(servicoPrestado);
		comanda.setTotal(totalComanda());
		return servicosPrestados;
	}

	public BigDecimal totalComanda() {
		BigDecimal total;

		total = new BigDecimal("0.0");

		for (ServicoPrestado sp : servicosPrestados) {
			total = total.add(sp.getServico().getValor());
		}

		comanda.setTotal(total);

		return total;
	}

	public List<Cliente> buscarClientes() {
		clientes = clienteDao.buscar();
		return clientes;

	}

	public List<Funcionario> buscarFuncionarios() {
		funcionarios = funcionarioDao.buscar();
		return funcionarios;

	}

	public List<Servico> buscarServicos() {
		servicos = servicoDao.buscar();
		return servicos;

	}

	/**
	 * @return the comandaDao
	 */
	public ComandaDao getComandaDao() {
		return comandaDao;
	}

	/**
	 * @param comandaDao
	 *            the comandaDao to set
	 */
	public void setComandaDao(ComandaDao comandaDao) {
		this.comandaDao = comandaDao;
	}

	/**
	 * @return the comandas
	 */
	public List<Comanda> getComandas() {
		return comandas;
	}

	/**
	 * @param comandas
	 *            the comandas to set
	 */
	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	/**
	 * @return the funcionarioDao
	 */
	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	/**
	 * @param funcionarioDao
	 *            the funcionarioDao to set
	 */
	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the clienteDao
	 */
	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	/**
	 * @param clienteDao
	 *            the clienteDao to set
	 */
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	/**
	 * @return the comanda
	 */
	public Comanda getComanda() {
		return comanda;
	}

	/**
	 * @param comanda
	 *            the comanda to set
	 */
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	/**
	 * @return the servicoPrestado
	 */
	public ServicoPrestado getServicoPrestado() {
		return servicoPrestado;
	}

	/**
	 * @param servicoPrestado
	 *            the servicoPrestado to set
	 */
	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	/**
	 * @return the servicosPrestados
	 */
	public List<ServicoPrestado> getServicosPrestados() {
		return servicosPrestados;
	}

	/**
	 * @param servicosPrestados
	 *            the servicosPrestados to set
	 */
	public void setServicosPrestados(List<ServicoPrestado> servicosPrestados) {
		this.servicosPrestados = servicosPrestados;
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
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes
	 *            the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the status
	 */
	public List<Status> getStatus() {
		return status;
	}

	/**
	 * @return the nomeStatus
	 */
	public List<String> getNomeStatus() {
		return nomeStatus;
	}

}
