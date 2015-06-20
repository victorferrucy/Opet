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
		contatoDao = new ContatoDao();

	}

	public void salvar() {
		enderecoDao.salvar(endereco);
		contatoDao.salvar(contato);
		clienteDao.salvar(cliente);

	}

	public void atualizar(Cliente cliente) {
		enderecoDao.atualizar(cliente.getEndereco());
		contatoDao.atualizar(cliente.getContato());
		clienteDao.atualizar(cliente);

	}

	public List<Cliente> buscar() {
		clientes = new ArrayList<Cliente>();
		clientes = clienteDao.buscar();
		System.out.println(clientes.size());
		for (Cliente cl : clientes) {
			System.out.println(cl.getNome());
		}

		return clientes;
	}

	public void deletar(Cliente cliente) {
		enderecoDao.atualizar(cliente.getEndereco());
		contatoDao.atualizar(cliente.getContato());
		clienteDao.deletar(cliente);

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
	 * @param enderecoDao the enderecoDao to set
	 */
	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}
	
}
