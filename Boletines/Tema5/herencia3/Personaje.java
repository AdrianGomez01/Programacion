package Tema5.herencia3;

public abstract class Personaje implements Comparable<Personaje>{
	// Constantes
	public static final int PV_MIN = 0;
	public static final int PV_MAX = 100;
	private static final int FUERZA_MINIMA = 0;
	private static final int FUERZA_MAXIMA = 20;
	private static final int INTELIGENCIA_MINIMA = 0;
	private static final int INTELIGENCIA_MAXIMA = 20;

	// Atributos
	private String nombre;
	private TRaza raza;
	protected int fuerza;
	private int inteligencia;
	private int maxPV;
	private int actualPV;

	public Personaje(String nombre, TRaza raza, int fuerza, int inteligencia, int maxPV) throws PersonajeException {
		this.nombre = nombre;
		this.raza = raza;
		this.setFuerza(fuerza);
		this.setInteligencia(inteligencia);
		this.setMaxPV(maxPV);
		this.actualPV = maxPV;
	}

	public String getNombre() {
		return nombre;
	}

	public TRaza getRaza() {
		return raza;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza >= FUERZA_MINIMA && fuerza <= FUERZA_MAXIMA) {
			this.fuerza = fuerza;
		}
		else {
			throw new PersonajeException("Valor de fuerza no válido");
		}
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia >= INTELIGENCIA_MINIMA && inteligencia <= INTELIGENCIA_MAXIMA) {
			this.inteligencia = inteligencia;
		}
		else {
			throw new PersonajeException("Valor de inteligencia no válido");
		}
	}

	public int getMaxPV() {
		return maxPV;
	}

	public void setMaxPV(int maxPV) throws PersonajeException {
		if (maxPV >= PV_MIN && maxPV <= PV_MAX) {
			this.maxPV = maxPV;
		}
		else {
			throw new PersonajeException("Valor de PV maximos no válido");
		}
	}

	public int getActualPV() {
		return actualPV;
	}
	
	public void setActualPV(int actualPV) throws PersonajeException {
		if (actualPV >= PV_MIN && actualPV <= PV_MAX) {
			this.actualPV = actualPV;
		}
		else {
			throw new PersonajeException("Valor de PV no válido");
		}
	}
	
	public boolean comprobarMuerte() {
		if(this.getActualPV() == 0) {
			return true;
		}
		return false;
	}
	
	//Comprueba quien de los dos personajes a comparar tiene menos vida.
	@Override
	public int compareTo(Personaje o) {
		return o.actualPV - this.actualPV;
	}

	@Override
	public String toString() {
		return "Personaje [PV_MAX=" + PV_MAX + ", nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza
				+ ", inteligencia=" + inteligencia + ", maxPV=" + maxPV + ", actualPV=" + actualPV + "]";
	}

}
