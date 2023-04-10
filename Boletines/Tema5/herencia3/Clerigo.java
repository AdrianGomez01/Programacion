package Tema5.herencia3;

public class Clerigo extends Personaje {
	// Constantes
	private static final int MIN_INTELIGENCIA_CLERIGO = 12;
	private static final int MAX_INTELIGENCIA_CLERIGO = 16;
	private static final int MIN_FUERZA_CLERIGO = 18;
	private static final int PUNTOS_CURACION = 10;
	// Atributos
	private String dios;

	public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int maxPV, String dios)
			throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, maxPV);
		this.dios = dios;
	}

	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza >= MIN_FUERZA_CLERIGO) {
			super.setFuerza(fuerza);
		} else {
			throw new PersonajeException("Valor de fuerza no válido");
		}
	}

	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia <= MAX_INTELIGENCIA_CLERIGO && inteligencia >= MIN_INTELIGENCIA_CLERIGO) {
			super.setInteligencia(inteligencia);
		} else {
			throw new PersonajeException("Valor de inteligencia no válido");
		}
	}

	public void curar(Personaje p) throws PersonajeException {
		if (this.dios != null) {
			if (p.getActualPV() != 0) {
				if (p.getActualPV() + PUNTOS_CURACION <= p.getMaxPV()) {
					p.setActualPV(p.getActualPV() + PUNTOS_CURACION);
				} else {
					p.setActualPV(p.getMaxPV());
				}
			} else {
				throw new PersonajeException("El personaje esta muerto");
			}
		}
		else {
			throw new PersonajeException("El clerigo no tiene dios asignado");
		}
	}
	

	@Override
	public String toString() {
		return "Clerigo [dios=" + dios + ", toString()=" + super.toString() + "]";
	}
	
	
}
