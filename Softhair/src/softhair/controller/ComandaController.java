/**
 * 
 */
package softhair.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import softhair.model.Cliente;
import softhair.model.Comanda;
import softhair.model.Funcionario;
import softhair.model.Servico;
import softhair.model.ServicoPrestado;
import softhair.model.dao.ClienteDao;
import softhair.model.dao.ComandaDao;
import softhair.model.dao.FuncionarioDao;
import softhair.model.dao.ServicoDao;

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
	private ClienteDao clienteDao;
	private ComandaDao comandaDao;
	
	private Funcionario funcionario;
	private Servico servico;
	private List<Funcionario> funcionarios;
	private List<Servico> servicos;
	private List<Cliente> clientes;

	private ServicoDao servicoDao;
	private FuncionarioDao funcionarioDao;

	public ComandaController() {
		comanda = new Comanda();
		comanda.setCliente(new Cliente());
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
	}

	public String novaComanda() {
		comanda = new Comanda();
		return "cadastrarComanda.xhtml?faces-redirect=true";
	}

	public String atualizarComanda(Comanda comanda) {
		this.comanda = comanda;
		return "alterarComanda.xhtml?faces-redirect=true";
	}

	public String visualizarComanda(Comanda comanda) {
		this.comanda = comanda;
		System.out.println("TOTAL COMANDA " + String.valueOf(comanda.getTotal()));
		return "visualizarComanda.xhtml?faces-redirect=true";
	}

	public void salvar() {
		servicosPrestados.add(servicoPrestado);
		comanda.setServicosPrestados(servicosPrestados);
		comandaDao.salvar(comanda);
		comanda = new Comanda();
		servicoPrestado = new ServicoPrestado();
		servicosPrestados = new ArrayList<ServicoPrestado>();
	}

	public void atualizar(Comanda comanda) {
		comandaDao.atualizar(comanda);
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
	
	public List<Cliente> buscarClientes(){
		clientes = clienteDao.buscar();
		return clientes;
		
	}
	
	public List<Funcionario> buscarFuncionarios(){
		funcionarios = funcionarioDao.buscar();
		return funcionarios;
		
	}
	
	public List<Servico> buscarServicos(){
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
	 * @param servicoPrestado the servicoPrestado to set
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
	 * @param servicosPrestados the servicosPrestados to set
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
	 * @param funcionario the funcionario to set
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
	 * @param servico the servico to set
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
	 * @param funcionarios the funcionarios to set
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
	 * @param servicos the servicos to set
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
	 * @param servicoDao the servicoDao to set
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
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
