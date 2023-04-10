package ExamenColecciones2023.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Liga {
	private List<Equipo> equipos;
	private String nombre;

	public Liga(String nombre) {
		super();
		this.equipos = new ArrayList<>();
		this.nombre = nombre;
	}

	/**
	 * Método que va a aceptar un equipo pasado por parámetro y va a añadirlo a la
	 * lista de equipos de la Liga, para ello tiene un iterador para recorrer la
	 * lista para poder comprobar que el equipo ya no exista en la Liga. Tambien va
	 * a comprobar que: 
	 * -El nombre del equipo no esté vacío, en cuyo caso saltará una excepción indicandolo. 
	 * -El equipo a introducir no tiene jugadores, en cuyo caso saltará una excepción indicandolo. 
	 * -El equipo a introducir no existe ya en la Liga, en cuyo caso saltará una excepción indicandolo.
	 * 
	 * He modificado el equals en la clase Equipo funcione en base al nombre.
	 * 
	 * @param e - Equipo el cual queremos anhadir.
	 * @throws LigaException - Si no se encuentra alguno de los dos equipos en la
	 *                       Liga salta la excepción.
	 */
	public void addEquipo(Equipo e) throws LigaException {

		Iterator<Equipo> it = equipos.iterator();

		if (e == null) {
			throw new LigaException("Error, introduzca un nombre para el equipo");
		} else {
			if (e.getJugadores() == null) {
				throw new LigaException("El equipo que desea introducir no tiene jugadores");
			} else {
				while (it.hasNext()) {
					if (it.next().equals(e)) {
						throw new LigaException("Error, el equipo indicado ya existe en la Liga");
					} else {
						equipos.add(e);
					}
				}
			}
		}
	}

	/**
	 * Método que recorre la lista Equipos usando un iterador buscando el equipo
	 * pasado por parámetro usando su metodo equals.
	 * 
	 * @param e - Equipo a buscar, pasado por parametro
	 * @throws LigaException - Salta si no se introduce un nombre a buscar o si no
	 *                       se encuentra el equipo en la Liga.
	 */
	public void eliminaEquipo(Equipo e) throws LigaException {
		Iterator<Equipo> it = equipos.iterator();
		if (e == null) {
			throw new LigaException("Error, introduzca un nombre para el equipo");
		} else {
			while (it.hasNext()) {
				if (it.next().equals(e)) {
					it.remove();
				} else {
					throw new LigaException("No se ha encontrado el equipo que desea eliminar");
				}
			}
		}
	}

	/**
	 * Une los jugadores de dos equipos al primero pasado por parámetro
	 * 
	 * @param e1 - Primer equipo
	 * @param e2 - Segundo equipo
	 * @throws LigaException -
	 */
	public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {

		if (!equipos.contains(e1) || !equipos.contains(e2)) {
			throw new LigaException("Uno o ambos equipos no pertenecen a la Liga");
		} else {
			Iterator<Jugador> it = e2.getJugadores().iterator();
			while (it.hasNext()) {
				e1.addJugador(it.next());
			}
		}
	}

	/**
	 * Método que devuelve una lista de jugadores con los jugadores en común entre
	 * dos equipos pasados por parámetro, creando en primer lugar una nueva lista
	 * basada en uno de los dos equipos, para porsteriormente usando .retainsAll
	 * retenga todos los jugadores que estén en ambos equipos.
	 * 
	 * @param e1 - Equipo numero 1 a comparar jugadores
	 * @param e2 - Equipo numero 2 a comparar jugadores
	 * @return - Lista con los jugadores que tiene en común ambos equipos.
	 * @throws LigaException - Si no se encuentra alguno de los dos equipos en la
	 *                       Liga salta la excepción.
	 */
	public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {

		if (!equipos.contains(e1) || !equipos.contains(e2)) {
			throw new LigaException("Uno o ambos equipos no pertenecen a la Liga");
		} else {
			List<Jugador> jugadoresComunes = new LinkedList<Jugador>(e2.getJugadores());
			jugadoresComunes.retainAll(e1.getJugadores());
			return jugadoresComunes;
		}

	}

	/**
	 * Método que usa una expresion lambda para hacer la media de todos los
	 * jugadores de la Liga, controlando que haya al menos un jugador.
	 * 
	 * @return - Devuelve la media de edad de todos los jugadores.
	 * @throws LigaException - Salta si no hay jugadores de los cuales obtener la
	 *                       edad.
	 */
	public double mediaEdad() throws LigaException {
		return todosLosJugadores().stream().mapToDouble(j -> j.getEdad()).average()
				.orElseThrow(() -> new LigaException("No hay jugadores en la Liga"));
	}

	/*
	 * Este método devuelve una lista de todos los jugadores ordenados por su Edad,
	 * usando una expresion Lambda y el metodo .sorted() el cual ordena de más mayor
	 * a más joven.
	 */
	public List<Jugador> jugadoresOrdenadosEdad() {
		return todosLosJugadores().stream()
				.sorted((j1, j2) -> j2.getFechaNacimiento().compareTo(j1.getFechaNacimiento())).toList();
	}

	/*
	 * Este método devuelve una lista de todos los jugadores ordenados
	 * alfabéticamente por Nombre, usando una expresion Lambda y el metodo .sorted()
	 * el cual ordena automaticamente siguiendo el orden natural.
	 */
	public List<Jugador> jugadoresOrdenadosNombre() {
		return todosLosJugadores().stream().sorted().toList();

	}

	/**
	 * Método que crea un nuevo Set "jugadoresAll" con todos los jugadores,
	 * recorriendo mediante un iterador todos los equipos y añadiendo sus jugadores
	 * al nuevo Set.
	 * 
	 * @return - Devuelve un set con todos los jugadores de todos los equipos.
	 */
	private Set<Jugador> todosLosJugadores() {
		HashSet<Jugador> jugadoresAll = new HashSet<Jugador>();
		Iterator<Equipo> it = equipos.iterator();
		while (it.hasNext()) {
			jugadoresAll.addAll(it.next().getJugadores());
		}
		return jugadoresAll;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
		sb.append("Equipos: ").append(System.lineSeparator());
		for (Equipo e : equipos) {
			sb.append(e).append(System.lineSeparator());
		}

		return sb.toString();

	}
}
