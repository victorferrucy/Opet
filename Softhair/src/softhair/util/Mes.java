/**
 * 
 */
package softhair.util;

/**
 * @author Victor Ferrucy
 *
 */
public enum Mes {
	JANEIRO(0), FEVEREIRO(1), MARÇO(2), ABRIL(3), MAIO(4), JUNHO(5), JULHO(6), AGOSTO(7), SETEMBRO(8), OUTUBRO(
			9), NOVEMBRO(10), DEZEMBRO(11);

	private final int numeroMes;

	Mes(int numeroMes) {
		
		this.numeroMes = numeroMes;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getNumeroMes() {
		return numeroMes;
	}
}
