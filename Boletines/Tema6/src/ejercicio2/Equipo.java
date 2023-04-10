package Tema6.src.ejercicio2;

import java.util.*;

public class Equipo<T>{
	private String nombreEquipo;
	private Set<T> conjuntoAlumnos;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoAlumnos = new HashSet<>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(T t) throws EquipoException {

		if (!conjuntoAlumnos.contains(t)) {
			conjuntoAlumnos.add(t);
		} else {
			throw new EquipoException("El alumno no existe");
		}

	}

	public void borrarAlumno(T t) throws EquipoException {

		if (conjuntoAlumnos.contains(t)) {
			conjuntoAlumnos.remove(t);
		} else {
			throw new EquipoException("El alumno no existe");
		}

	}

	/**
	 * Devuelve una cadena con el listado de los Alumnos
	 * 
	 * @return Cadena con el listado de Alumnos
	 */
	public String listadoDeAlumnos() {

		StringBuilder s = new StringBuilder();
		Iterator<T> i = conjuntoAlumnos.iterator();

		while (i.hasNext()) {
			s.append(i.next() + "\n");
		}
		return s.toString();

	}

	// TODO va a dar un problema
	public T buscarAlumno(T t) {

		if (conjuntoAlumnos.contains(t)) {
			return t;
		}
		return null;
	}

	/**
	 * Une un equipo con otro, añadiendo al equipo los jugadores del otro.
	 * 
	 * @param otro Otro equipo que se va a unir
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo<T> fusionDeEquipos(Equipo<T> otro) {

		this.conjuntoAlumnos.addAll(otro.conjuntoAlumnos);

		return this;

	}

	/**
	 * Modifica el equipo para que tenga unicamente los elementos que están en los dos equipos
	 * 
	 * @param otro Otro equipo
	 * @return Equipo resultado de la intersección
	 */
	public Equipo<T> intersecionDeEquipos(Equipo<T> otro) {

		this.conjuntoAlumnos.retainAll(otro.conjuntoAlumnos);

		return this;

	}

	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", conjuntoAlumnos=" + conjuntoAlumnos + "]";
	}

}
