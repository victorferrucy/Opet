/**
 * 
 */
package softhair.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import softhair.model.Contato;
import softhair.model.Endereco;
import softhair.model.Fornecedor;
import softhair.model.dao.ContatoDao;
import softhair.model.dao.EnderecoDao;
import softhair.model.dao.FornecedorDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
@ManagedBean
@SessionScoped
public class FornecedorController {
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	private Endereco endereco;
	private Contato contato;
	private FornecedorDao fornecedorDao;
	private EnderecoDao enderecoDao;
	private ContatoDao contatoDao;

	public FornecedorController() {
		setFornecedor(new Fornecedor());
		setEndereco(new Endereco());
		setContato(new Contato());
		fornecedor.setEndereco(endereco);
		fornecedor.setContato(contato);
		fornecedorDao = new FornecedorDao();
		setEnderecoDao(new EnderecoDao());
		contatoDao = new ContatoDao();

	}

	public String novoFornecedor(){
		fornecedor = new Fornecedor();
		fornecedor.setContato(new Contato());
		fornecedor.setEndereco(new Endereco());
		return "cadastrarFornecedor.xhtml?faces-redirect=true";
	}
	
	public String atualizarFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		return "alterarFornecedor.xhtml?faces-redirect=true";
	}
	
	public String visualizarFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		return "visualizarFornecedor.xhtml?faces-redirect=true";
	}
	
	public void salvar() {
		fornecedorDao.salvar(fornecedor);
		
		fornecedor = new Fornecedor();
		fornecedor.setEndereco(new Endereco());
		fornecedor.setContato(new Contato());

	}

	public void atualizar(Fornecedor fornecedor) {
		System.out.println(fornecedor.getEndereco().toString());
		fornecedorDao.atualizar(fornecedor);

	}

	public List<Fornecedor> buscar() {
		fornecedores = new ArrayList<Fornecedor>();
		fornecedores = fornecedorDao.buscar();

		return fornecedores;
	}

	public List<Fornecedor> deletar(Fornecedor fornecedor) {
		boolean deletou;
		
		deletou = fornecedorDao.deletar(fornecedor);
		
		if(deletou){
			fornecedores = fornecedorDao.buscar();
		}
		
		return fornecedores;

	}

	/**
	 * @return the cliente
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor= fornecedor;
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
