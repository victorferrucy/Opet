/**
 * 
 */
package softhair.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Victor Ferrucy
 *
 */

@Entity
@Table
@SequenceGenerator(sequenceName = CargoSistema.CARGO_SEQUENCE, name = CargoSistema.CARGO_SEQUENCE, initialValue = 0, allocationSize = 1)
public class CargoSistema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5977243474716238140L;
	
	public static final String CARGO_SEQUENCE = "cargo_sequence";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CARGO_SEQUENCE)
	private int idCargoSistema;
	@Column(name="nome_cargo")
	private String nomeCargo;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCargoSistema;
		result = prime * result + ((nomeCargo == null) ? 0 : nomeCargo.hashCode());
		return result;
	}
	/* (non-Javadoc)
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
		CargoSistema other = (CargoSistema) obj;
		if (idCargoSistema != other.idCargoSistema)
			return false;
		if (nomeCargo == null) {
			if (other.nomeCargo != null)
				return false;
		} else if (!nomeCargo.equals(other.nomeCargo))
			return false;
		return true;
	}
	/**
	 * @return the idCargoSistema
	 */
	public int getIdCargoSistema() {
		return idCargoSistema;
	}
	/**
	 * @param idCargoSistema the idCargoSistema to set
	 */
	public void setIdCargoSistema(int idCargoSistema) {
		this.idCargoSistema = idCargoSistema;
	}
	/**
	 * @return the nomeCargo
	 */
	public String getNomeCargo() {
		return nomeCargo;
	}
	/**
	 * @param nomeCargo the nomeCargo to set
	 */
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
