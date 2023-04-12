package ExamenColecciones2022.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mazo {
	/**
	 * Creamos un mapa que tiene como clave el propio Cromo y como
	 * valor el n�mero de unidades del mismo que tenemos en el mazo.
	 * Cuidado porque al hacer Cromo clave, tenemos que codificar 
	 * el m�todo equals en la clase Cromo.
	 */
	private Map<Cromo, Integer> mazo;
	
	public Mazo() {
		mazo = new HashMap<>();
	}
	
	/**
	 * @return the mazo
	 */
	public Map<Cromo, Integer> getMazo() {
		return mazo;
	}

	/**
	 * A�ade un cromo a mi mazo
	 * @param c
	 * @return
	 */
	public int addCromo(Cromo c) {
		return this.addCromo(c, 1);		
	}
	
	/**
	 * Permite a�adir cualquier cantidad de un cromo dado a mi mazo
	 * @param c el cromo del cual voy a a�adir numeroCromos unidades
	 * @param numeroCromos el n�mero de unidades del cromo c que voy a a�adir al mazo
	 * @return el n�mero actual de unidades del cromo c resultante
	 */
	public int addCromo(Cromo c, int numeroCromos) {
		if (this.mazo.containsKey(c)) {
			this.mazo.put(c, Integer.valueOf(this.mazo.get(c).intValue() + numeroCromos));
		}
		else {
			this.mazo.put(c, Integer.valueOf(numeroCromos));
		}
		
		return this.mazo.get(c).intValue();
	}
	
	/**
	 * Coge un cromo (de otro mazo, pero no se trata eso aqu�) y lo a�ade a mi mazo.
	 * Al mismo tiempo, elimina una unidad de uno de mis cromos. Si fuera la �ltima
	 * unidad, se ha de eliminar el cromo tambi�n.
	 * @param mio El cromo de mi mazo que voy a intercambiar
	 * @param nuevo El cromo de otro mazo que voy a recibir
	 * @throws MazoException Si intento intercambiar un cromo de mi mazo que no tengo
	 */
	public void intercambiar(Cromo mio, Cromo nuevo) throws MazoException {
		if (!this.mazo.containsKey(mio)) {
			throw new MazoException("No puedes intercambiar un cromo que no tienes");
		}
		
		if (this.mazo.get(mio).intValue() > 1) {
			// Tengo m�s de uno, por tanto el cromo se quedar� en el mazo
			this.mazo.put(mio, Integer.valueOf(this.mazo.get(mio).intValue() - 1));
		}
		else {
			// Tan solo tengo 1, por lo que habr� que eliminarse del mazo
			this.mazo.remove(mio);
		}
		
		// Por �ltimo a�adimos el nuevo cromo al mazo
		this.addCromo(nuevo);
	}
	
	/**
	 * Mezcla mi mazo con otro que recibo como par�metro
	 * @param otro el mazo con el que voy a mezclar el m�o
	 */
	public void mezclar (Mazo otro) {
		otro.getMazo().forEach((cromo, unidades) -> this.addCromo(cromo, unidades));
	}
	
	/**
	 * Al no permitir los Map elementos repetidos, el tama�o del mismo representa
	 * el n�mero de cromos distintos que tengo
	 * @return
	 */
	public int contarDiferentes() {
		return this.mazo.size();
	}
	
	/**
	 * Devuelve los cromos de un equipo dado
	 * @param equipo El nombre del equipo
	 * @return Una lista con los cromos de dicho equipo
	 */
	public List<Cromo> cromosDeUnEquipo(String equipo) {
		/*
		 * Filtramos los cromos del mazo. Solo pasar�n el filtro aquellos escudos
		 * cuyo nombre sea equipo, o aquellos jugadores cuyo equipo sea equipo.
		 */
		return mazo.keySet().stream().filter(c -> {
			if (c instanceof Escudo) {
				Escudo e = (Escudo) c;
				return e.getNombre().equals(equipo);
			}
			else {
				return ((Jugador) c).getEquipo().equals(equipo);
			}
		}).collect(Collectors.toList());
	}
	
	/**
	 * Calcula la altura media de un equipo
	 * @param equipo El nombre del equipo
	 * @return La altura media de los jugadores de un equipo dado o NaN 
	 * si no existe dicho equipo o no tenemos jugadores del mismo
	 */
	public double alturaMedia(String equipo) {
		return mazo.keySet().stream().filter(c -> {
			if (c instanceof Jugador) {
				Jugador j = (Jugador) c;
				return j.getEquipo().equals(equipo);
			}
			else {
				return false;
			}
		}).mapToInt(c -> ((Jugador) c).getAltura())
				.average().orElse(Double.NaN);
	}
	
	/**
	 * Devuelve los cromos de nuestro mapa
	 * @return
	 */
	public List<Cromo> getLista() {
		return mazo.keySet().stream().collect(Collectors.toList());
	}
	
	/**
	 * Devuelve una lista con todos nuestros cromos ordenados por el orden dado
	 * @return Una lista con todos nuestros cromos ordenados por el orden dado
	 */
	public List<Cromo> ordenar(){
		return mazo.keySet().stream().sorted((a, b) -> {
			if (a instanceof Escudo) {
				// a es un escudo, �y b?
				if (b instanceof Escudo) {
					// Los dos son escudos, comparamos por nombre
					Escudo e1 = (Escudo) a;
					Escudo e2 = (Escudo) b;
					return e1.getNombre().compareTo(e2.getNombre());
				}
				else {
					// a es un escudo y b un jugador
					return -1;
				}				
			}
			else {
				// a es un jugador, �y b?
				if (b instanceof Jugador) {
					// Los dos son jugadores, comparamos por nombre
					Jugador j1 = (Jugador) a;
					Jugador j2 = (Jugador) b;
					return j1.getNombre().compareTo(j2.getNombre());
				}
				else {
					// a es un jugador y b un escudo
					return 1;
				}
			}
		}).collect(Collectors.toList());
	}
	
	/**
	 * Devuelve una lista de aquellos equipos de los cuales tengo todos sus jugadores,
	 * incluido el escudo
	 * @return
	 */
	public List<String> equipoCompleto(){
		List<String> equipos = new LinkedList<>();
		// Primero obtengo los escudos, para despu�s ver si tengo todos sus jugadores.
		Iterator<Cromo> it = mazo.keySet().stream().filter(c -> c instanceof Escudo).iterator();
		
		// Por cada escudo, cuento los jugadores que tengo. Si los tengo todos, lo a�ado a la lista
		while (it.hasNext()) {
			Escudo escudo = (Escudo) it.next();
			long jugadoresQueTengo = mazo.keySet().stream()
					.filter(c -> c instanceof Jugador)
					.filter(c -> ((Jugador) c).getEquipo().equals(escudo.getNombre()))
					.count();
			if (jugadoresQueTengo == escudo.getNumeroJugadores()) {
				equipos.add(escudo.getNombre());
			}
		}
		
		return equipos;
	}
	
}
