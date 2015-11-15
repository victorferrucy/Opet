package softhair.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName = Usuario.USUARIO_SEQUENCE, name = Usuario.USUARIO_SEQUENCE, initialValue = 0, allocationSize = 5)

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1504440720328564732L;

	public static final String USUARIO_SEQUENCE = "usuario_sequence";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USUARIO_SEQUENCE)
	private int idUsuario;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	@Column
	private String login;
	@Column
	private String senha;
	@ManyToMany
	private List<CargoSistema> cargo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
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
	 * @return the cargo
	 */
	public List<CargoSistema> getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(List<CargoSistema> cargo) {
		this.cargo = cargo;
	}
}
