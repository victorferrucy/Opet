/**
 * 
 */
package softhair.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import softhair.model.Cliente;
import softhair.model.Contato;
import softhair.model.Endereco;
import softhair.model.dao.ClienteDao;
import softhair.model.dao.ContatoDao;
import softhair.model.dao.EnderecoDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
@ManagedBean
@SessionScoped
public class ClienteController {
	private Cliente cliente;
	private List<Cliente> clientes;
	private Endereco endereco;
	private Contato contato;
	private ClienteDao clienteDao;
	private EnderecoDao enderecoDao;
	private ContatoDao contatoDao;

	public ClienteController() {
		setCliente(new Cliente());
		setEndereco(new Endereco());
		setContato(new Contato());
		cliente.setEndereco(endereco);
		cliente.setContato(contato);
		clienteDao = new ClienteDao();
		setEnderecoDao(new EnderecoDao());
		setContatoDao(new ContatoDao());

	}

	public String paginaInicial() {
		return "telaInicial.xhtml?faces-redirect=true";
	}

	public String novoCliente() {
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		cliente.setContato(new Contato());
		return "cadastrarCliente.xhtml?faces-redirect=true";
	}

	public String atualizarCliente(Cliente cliente) {
		this.cliente = cliente;
		return "alterarCliente.xhtml?faces-redirect=true";
	}

	public String visualizarCliente(Cliente cliente) {
		this.cliente = cliente;
		return "visualizarCliente.xhtml?faces-redirect=true";
	}

	public void salvar() {
		clienteDao.salvar(cliente);

		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		cliente.setContato(new Contato());

	}

	public void atualizar(Cliente cliente) {
		clienteDao.atualizar(cliente);
	}

	public List<Cliente> buscar() {
		clientes = new ArrayList<Cliente>();
		clientes = clienteDao.buscar();

		return clientes;
	}

	public List<Cliente> deletar(Cliente clienteSel) {
		boolean deletou = false;

		deletou = clienteDao.deletar(clienteDao.buscar(clienteSel));

		if (deletou) {
			clientes = clienteDao.buscar();
		}
		return clientes;
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
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the contato
	 */
	public Contato getContato() {
		return contato;
	}

	/**
	 * @param contato
	 *            the contato to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	/**
	 * @return the enderecoDao
	 */
	public EnderecoDao getEnderecoDao() {
		return enderecoDao;
	}

	/**
	 * @param enderecoDao
	 *            the enderecoDao to set
	 */
	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
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
	 * @return the contatoDao
	 */
	public ContatoDao getContatoDao() {
		return contatoDao;
	}

	/**
	 * @param contatoDao
	 *            the contatoDao to set
	 */
	public void setContatoDao(ContatoDao contatoDao) {
		this.contatoDao = contatoDao;
	}

}
