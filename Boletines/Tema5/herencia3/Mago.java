package Tema5.herencia3;

import java.util.Arrays;

public class Mago extends Personaje {
	// Constantes
	private static final int NUM_HECHIZOS = 4;
	private static final int MAX_FUERZA_MAGO = 15;
	private static final int MIN_INTELIGENCIA_MAGO = 17;
	private static final int SPELL_DAMAGE = 10;

	// Atributos
	private String[] hechizos;

	public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int maxPV) throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, maxPV);
		hechizos = new String[NUM_HECHIZOS];
	}

	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza <= MAX_FUERZA_MAGO) {
			super.setFuerza(fuerza);
		} else {
			throw new PersonajeException("Valor de fuerza no válido");
		}
	}

	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia >= MIN_INTELIGENCIA_MAGO) {
			super.setInteligencia(inteligencia);
		} else {
			throw new PersonajeException("Valor de inteligencia no válido");
		}
	}

	public void aprenderHechizo(String hechizo) throws PersonajeException {
		int posicionVacia = -1;
		for (int i = 0; i < hechizos.length; i++) {
			if (hechizos[i] == null && posicionVacia == -1) {
				posicionVacia = i;
			}
			if(hechizo.equals(hechizos[i])) {
				throw new PersonajeException("El mago ya conoce este hechizo");
			}
		}
		if(posicionVacia != -1) {
			hechizos[posicionVacia] = hechizo;
		}
		else {
			throw new PersonajeException("No caben mas hechizos en el grimorio");
		}
	}

	public void lanzarHechizo(Personaje p, String hechizo) throws PersonajeException {
		boolean encontrado = false;
		if (p != this) {
			for (int i = 0; i < hechizos.length; i++) {
				if (hechizo.equals(hechizos[i])) {
					hechizos[i] = null;
					try {
						p.setActualPV(p.getActualPV() - SPELL_DAMAGE);
					} catch (PersonajeException e) {
						p.setActualPV(Personaje.PV_MIN);
					}
					encontrado = true;
					break;

				}
			}
			if (!encontrado) {
				throw new PersonajeException("No se ha encontrado el hechizo");
			}
		}
		else {
			throw new PersonajeException("No te puedes atacar a ti mismo");
		}
	}

	@Override
	public String toString() {
		return "Mago [hechizos=" + Arrays.toString(hechizos) + ", toString()=" + super.toString() + "]";
	}

}
