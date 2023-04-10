
public class Jugador extends Cromo {
	
	private String equipo;
	private int altura;
	
	public Jugador(int id, String nombre, String equipo, int altura) {
		super(id, nombre);
		this.equipo = equipo;
		this.altura = altura;
	}

	

	/**
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	
}
