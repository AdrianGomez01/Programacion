package ejercicio1;

import java.util.HashMap;

public class NetPlease {

	// Hashmap donde por cada tema, podemos acceder a las películas de ese tema
	private HashMap<String, PeliculasDeUnTema> mapPeliculas;

	public NetPlease() {
		mapPeliculas = new HashMap<String, PeliculasDeUnTema>();

	}

	public void annadirTema(String tema) throws NetPleaseException {

		tema = tema.toUpperCase();
		if (mapPeliculas.containsKey(tema)) {
			throw new NetPleaseException("Ya existe ese tema");
		}

		mapPeliculas.put(tema, new PeliculasDeUnTema(tema));
	}

	public void addPelicula(String tema, Pelicula pelicula) throws NetPleaseException {
		PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);

		if (listaPeliculasDeUnTema == null) {
			throw new NetPleaseException("No existe el tema " + tema);
		}
		listaPeliculasDeUnTema.addPelicula(pelicula);
	}

	public void listadoDeTodasPeliculasDeTodosLosTemas() {

		for (PeliculasDeUnTema listaPelisTema : mapPeliculas.values()) {
			System.out.println(listaPelisTema);
		}
	}

	public void borrarPeliculaDeUnTema(String tema, String titulo) throws NetPleaseException {

		PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);

		if (listaPeliculasDeUnTema == null) {
			throw new NetPleaseException("No existe el tema " + tema);
		}
		if (!listaPeliculasDeUnTema.borrar(titulo)) {
			throw new NetPleaseException("no existe la pelicula " + titulo);
		}

	}

	/**
	 * Con la expresion lambda, recorremos el hasmap de temas y buscamos la pelicula
	 * de cada tema. Si la cuentra devuelve el tema, si no lanza una excepción.
	 * 
	 * @param titulo
	 * @return
	 * @throws NetPleaseException
	 */
	public String temaDePelicula(String titulo) throws NetPleaseException {

		return mapPeliculas.values().stream()
				.filter(listaPelisTema -> listaPelisTema.buscarPeliculaPorTitulo(titulo) != null).findFirst()
				.orElseThrow(() -> new NetPleaseException("No existe la peicula" + titulo)).getTema();
	}

}
