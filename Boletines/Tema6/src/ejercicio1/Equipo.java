package Tema6.src.ejercicio1;

import java.util.*;

public class Equipo {
	private String nombreEquipo;
	private Set<Alumno> conjuntoAlumnos;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoAlumnos = new HashSet<Alumno>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {

		if (!conjuntoAlumnos.contains(nuevoAlumno)) {
			conjuntoAlumnos.add(nuevoAlumno);
		} else {
			throw new EquipoException("El alumno no existe");
		}

	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {

		if (conjuntoAlumnos.contains(alumnoABorrar)) {
			conjuntoAlumnos.remove(alumnoABorrar);
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
		Iterator<Alumno> i = conjuntoAlumnos.iterator();

		while (i.hasNext()) {
			s.append(i.next() + "\n");
		}
		return s.toString();

	}

	// TODO va a dar un problema
	public Alumno buscarAlumno(Alumno alumnoBuscado) {

		if (conjuntoAlumnos.contains(alumnoBuscado)) {
			return alumnoBuscado;
		}
		return null;
	}

	/**
	 * Une un equipo con otro, añadiendo al equipo los jugadores del otro.
	 * 
	 * @param otro Otro equipo que se va a unir
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo fusionDeEquipos(Equipo otro) {

		this.conjuntoAlumnos.addAll(otro.conjuntoAlumnos);

		return this;

	}

	/**
	 * Modifica el equipo para que tenga unicamente los elementos que están en los dos equipos
	 * 
	 * @param otro Otro equipo
	 * @return Equipo resultado de la intersección
	 */
	public Equipo intersecionDeEquipos(Equipo otro) {

		this.conjuntoAlumnos.retainAll(otro.conjuntoAlumnos);

		return this;

	}

	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", conjuntoAlumnos=" + conjuntoAlumnos + "]";
	}

}
