package ExamenColecciones2021.src.ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Pelicula {
	private String titulo;
	private int annoEstreno;
	private ArrayList<Opinion> opiniones;
	private HashSet<String> actores;

	public Pelicula(String titulo, int annoEstreno) {
		super();
		this.titulo = titulo;
		this.annoEstreno = annoEstreno;
		actores = new HashSet<String>();
		opiniones = new ArrayList<Opinion>();
	}

	public void annadirOpinion(Opinion opinion) {
		opiniones.add(opinion);
	}

	public void annadirActor(String actor) {
		actores.add(actor);
	}

	/**
	 * Suma la valoración de todas las opiniones de una pelicula, recorriendo las
	 * opiniones con un iterador y añadiendo/sumando la valoración a una variable llamda
	 * "media"
	 * 
	 * @return - Devuelve el resultado dividido entre el número de opiniones.
	 */
	public double mediaDeOpiniones() {
		
		/*
		 * 
		 double media = 0;
	
		Iterator<Opinion> i = opiniones.iterator();
		while (i.hasNext()) {
			Opinion opinion = i.next();
			media =+ opinion.getValoracion();
		}
		return media / opiniones.size();
		*/ 
		return opiniones.stream().mapToDouble(o -> (double) o.getValoracion()).average().orElse(0);
	} 

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public HashSet<String> getActores() {
		return actores;
	}

	public int getAnnoEstreno() {
		return annoEstreno;
	}

	public void setAnnoEstreno(int annoEstreno) {
		this.annoEstreno = annoEstreno;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", annoEstreno=" + annoEstreno + "]" + " Media de opiniones "
				+ mediaDeOpiniones();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
