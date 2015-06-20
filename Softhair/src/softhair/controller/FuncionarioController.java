/**
 * 
 */
package softhair.controller;

import java.util.ArrayList;
import java.util.List;

import softhair.model.Cliente;
import softhair.model.Contato;
import softhair.model.Endereco;
import softhair.model.Funcionario;
import softhair.model.dao.ClienteDao;
import softhair.model.dao.ContatoDao;
import softhair.model.dao.EnderecoDao;
import softhair.model.dao.FuncionarioDao;

/**
 * @author Victor Ferrucy
 * @since 19/06/2015
 * @version 1.3
 */
public class FuncionarioController {
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	

	private Endereco endereco;
	private Contato contato;
	private FuncionarioDao funcionarioDao;
	private EnderecoDao enderecoDao;
	private ContatoDao contatoDao;

	public FuncionarioController() {
		setFuncionario(new Funcionario());
		setEndereco(new Endereco());
		setContato(new Contato());
		funcionario.setEndereco(endereco);
		funcionario.setContato(contato);
		funcionarioDao = new FuncionarioDao();
		setEnderecoDao(new EnderecoDao());
		contatoDao = new ContatoDao();

	}

	public void salvar() {
		enderecoDao.salvar(endereco);
		contatoDao.salvar(contato);
		funcionarioDao.salvar(funcionario);

	}

	public void atualizar(Funcionario funcionario) {
		enderecoDao.atualizar(funcionario.getEndereco());
		contatoDao.atualizar(funcionario.getContato());
		funcionarioDao.atualizar(funcionario);

	}

	public List<Funcionario> buscar() {
		funcionarios = new ArrayList<Funcionario>();
		funcionarios = funcionarioDao.buscar();

		return funcionarios;
	}

	public void deletar(Funcionario funcionario) {
		enderecoDao.atualizar(funcionario.getEndereco());
		contatoDao.atualizar(funcionario.getContato());
		funcionarioDao.deletar(funcionario);

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
	 * @return the funcionarioDao
	 */
	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	/**
	 * @param funcionarioDao the funcionarioDao to set
	 */
	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

	/**
	 * @return the contatoDao
	 */
	public ContatoDao getContatoDao() {
		return contatoDao;
	}

	/**
	 * @param contatoDao the contatoDao to set
	 */
	public void setContatoDao(ContatoDao contatoDao) {
		this.contatoDao = contatoDao;
	}
}
