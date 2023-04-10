
public class Escudo extends Cromo {
	private int fundacion, numeroJugadores;
	
	
	public Escudo(int id, String nombre, int fundacion, int numeroJugadores) {
		super(id, nombre);
		this.fundacion = fundacion;
		this.numeroJugadores = numeroJugadores;
	}


	/**
	 * @return the fundacion
	 */
	public int getFundacion() {
		return fundacion;
	}


	/**
	 * @return the numeroJugadores
	 */
	public int getNumeroJugadores() {
		return numeroJugadores;
	}
	
	
	
}
