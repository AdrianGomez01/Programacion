package ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PeliculasDeUnTema {

	private String tema;
	private LinkedList<Pelicula> listaPeliculasDeUnTema;

	public PeliculasDeUnTema(String tema) {
		this.tema = tema;
		listaPeliculasDeUnTema = new LinkedList<Pelicula>();
	}

	public String getTema() {
		return getTema();
	}

	/**
	 * Método que añade una pelicula a nuestra lista enlazada de peliculas.
	 * 
	 * @param pelicula - Es la pelicula que queremos introducir, pasada por
	 *                 parámetro perteneciente a la clase Pelicula.
	 * @throws NetPleaseException - Salta si introducimos una pelicula cuyo titulo
	 *                            coincide con una ya insertada en la Lista y su año
	 *                            de estreno es igual o inferior.
	 */
	public void addPelicula(Pelicula pelicula) throws NetPleaseException {

		Iterator<Pelicula> listaPeliculas = listaPeliculasDeUnTema.iterator();
		boolean anhadido = false;
		while (listaPeliculas.hasNext() && !anhadido) {
			if (listaPeliculas.next().getTitulo() != pelicula.getTitulo()
					&& listaPeliculas.next().getAnnoEstreno() <= pelicula.getAnnoEstreno()) {
				anhadido = true;
			} else {
				throw new NetPleaseException("La pelicula introducida está repetida");
			}
		}
		listaPeliculasDeUnTema.add(pelicula);
	}

	/**
	 * Método para borrar peliculas de un año de estreno.
	 * 
	 * @param anno - Año del cual vamos a borrar las peliculas.
	 * @throws NetPleaseException - Salta la excepción si se introduce un año del
	 *                            cual no hay ninguna pelicula.
	 */
	public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {

		int tamanho = listaPeliculasDeUnTema.size();
		listaPeliculasDeUnTema = listaPeliculasDeUnTema.stream().filter(p -> p.getAnnoEstreno() != anno)
				.collect(Collectors.toCollection(LinkedList::new));
		if (tamanho == listaPeliculasDeUnTema.size()) {
			throw new NetPleaseException("No existe ninguna pelicula del año " + anno);
		}
	}

	/**
	 * Método que añade una opinion a una pelicula.
	 * 
	 * @param tituloPelicula - Título de la pelicula a la que vamos a añadirle la
	 *                       opinion, será pasado por parámetro.
	 * @param opinion        - Opinion de la pelicula la cual vamos a añadir. Será
	 *                       pasado por parámetro.
	 * @throws NetPleaseException - Salta la excepción si introducimos un título de
	 *                            pelicula la cual no está en nuestra lista.
	 */
	public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {

		Iterator<Pelicula> listaPeliculas = listaPeliculasDeUnTema.iterator();

		boolean opinionAnhadida = false;
		while (listaPeliculas.hasNext() && !opinionAnhadida) {
			Pelicula p = listaPeliculas.next();
			if (p.getTitulo().equals(tituloPelicula)) {
				opinionAnhadida = true;
				p.annadirOpinion(opinion);
			} else {
				throw new NetPleaseException("No se ha encontrado la pelicula introducida");
			}
		}

	}

	/**
	 * @return - Devuelve una lista usando un flujo para ordenar según la media ,
	 *         haciendo uso del método .mediaDeOpiniones() de la clase Pelicula.
	 */
	public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {
		return listaPeliculasDeUnTema.stream()
				.sorted((v1, v2) -> Double.compare(v1.mediaDeOpiniones(), (v2.mediaDeOpiniones()))).toList();

	} 

	public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) {
		return listaPeliculasDeUnTema.stream().filter(p -> p.getActores().contains(actor)).toList(); 
	}

	public Pelicula buscarPeliculaPorTitulo(String titulo) {

		for (Pelicula pelicula : listaPeliculasDeUnTema) {
			if (pelicula.getTitulo().equals(titulo)) {
				return pelicula;
			}
		}
		return null;
	}

	/**
	 * Borra una pelicula de la lista de peliculas de un tema.
	 * 
	 * @param titulo
	 * @return - Devuelve true si se ha borrado la pelicula y false si no se ha encontrado.
	 */
	public boolean borrar(String titulo) {
		return listaPeliculasDeUnTema.removeIf(p -> p.getTitulo().equals(titulo));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeliculasDeUnTema other = (PeliculasDeUnTema) obj;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tema " + tema + "\n");
		for (Pelicula pelicula : listaPeliculasDeUnTema) {
			sb.append(pelicula + "\n");
		}
		return sb.toString();
	}

}
