package softhair.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Colaborador {
	@Id
	@GeneratedValue
	private int idColaborador;
	@OneToOne
	@JoinColumn(name = "idContato")
	private Contato contato;
	@OneToOne
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	@Column
	private String nome;
	@Column
	private String sobrenome;
	@Column
	private String cpf;
	@Column
	private String rg;
	@Column
	private String sexo;
	@Column
	private Calendar dataNascimento;

	public Colaborador() {

	}

	public Colaborador(int idColaborador, Contato contato, Endereco endereco,
			String nome, String sobrenome, String cpf, String rg, String sexo,
			Calendar dataNascimento) {
		this.setIdColaborador(idColaborador);
		this.setContato(contato);
		this.setEndereco(endereco);
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setSexo(sexo);
		this.setDataNascimento(dataNascimento);

	}

	/**
	 * @return the idColaborador
	 */
	public int getIdColaborador() {
		return idColaborador;
	}

	/**
	 * @param idColaborador
	 *            the idColaborador to set
	 */
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome
	 *            the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg
	 *            the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the dataNascimento
	 */
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
