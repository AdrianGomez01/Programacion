package ejercicio7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Receta {
	private String nombreReceta;
	private int minutosDePreparacion;
	private HashSet<Ingrediente> ingredientes;
	private LinkedList<String> pasos;

	public Receta(String nombreReceta, int minutosPreparacion) throws RecetaException {
		this.nombreReceta = nombreReceta.toUpperCase();
		setMinutosDePreparacion(minutosPreparacion);
		ingredientes = new HashSet<Ingrediente>();
		pasos = new LinkedList<String>();
	}

	public int getMinutosDePreparacion() {
		return minutosDePreparacion;
	}

	public void setMinutosDePreparacion(int minutosDePreparacion) throws RecetaException {
		if (minutosDePreparacion <= 0) {
			throw new RecetaException("Minutos incorrectos");
		}
		this.minutosDePreparacion = minutosDePreparacion;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void annadirPasoAlFinal(String paso) {
		pasos.add(paso.toUpperCase());
	}

	/**
	 * Recibe un objeto ingrediente, comprueba que ese ingrediente esté en la lista
	 * de ingredientes, si lo está suma la cantidad del ingrediente ya existente y
	 * la del nuevo, en caso de no estar en la lista lo añade.
	 * 
	 * @param ingredienteNuevo
	 */
	public void annadirIngrediente(Ingrediente ingredienteNuevo) {

		Iterator<Ingrediente> it = ingredientes.iterator();
		boolean ingredienteEncontrado = false;

		while (it.hasNext() && !ingredienteEncontrado) {
			Ingrediente ingredienteExistente = it.next();

			if (ingredienteExistente.equals(ingredienteNuevo)) {
				// Establece la cantidad del ingrediente existente como la que ya tenía + la
				// cantidad del ingrediente a añadir
				ingredienteExistente.setCantidad(ingredienteExistente.getCantidad() + ingredienteNuevo.getCantidad());
				ingredienteEncontrado = true;
			}
		}
		if (!ingredienteEncontrado) {
			ingredientes.add(ingredienteNuevo);
		}

	}

	/**
	 * Comprueba si esta receta necesita el ingrediente pasado por parametro o no.
	 * Lo comvertimos a un objeto debido a que el metodo contains llama al metodo
	 * equals en ingrediente, el cual acepta por parametro un objeto y compara
	 * unicamente su nombre.
	 * 
	 * @param nombreIngrediente
	 * @return true si lo necesita, false si no.
	 */
	public boolean necesitaIngrediente(String nombreIngrediente) {
		return ingredientes.contains(new Ingrediente(nombreIngrediente));
	}

	/**
	 * Borra un ingrediente buscandolo en la receta.
	 * @param ingredienteABorrar - Es el ingrediente que vamos a buscar en la receta para borrarlo
	 * @throws RecetaException - Si no encuentra el ingrediente buscado en la lista
	 */
	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException{
		if (!ingredientes.contains(ingredienteABorrar)) {
			throw new RecetaException("El ingrediente a borrar no se encuentra en la lista");
		}
		else {
			for (String paso : pasos) {
				if (paso.contains(ingredienteABorrar.getNombreIngrediente())){
					pasos.remove(paso);
				}
			}
			ingredientes.remove(ingredienteABorrar);
		}
	}

	/**
	 * Comprueba si en la posicion del paso existente esta en el rando de la lista,
	 * en caso congrario lanza una excepcion. si se encuentra en el rango, comprueba
	 * que el paso nuevo y el existente sean distientos, pasra asi añadir el nuevo
	 * en una posicion posterior al existente.
	 * 
	 * @param pasoNuevo
	 * @param pasoExistente
	 * @throws RecetaException
	 */
	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
		// Guardamos el indice de la posicion del paso existente en una variable
		int indicePasoExistente = pasos.indexOf(pasoExistente);

		if (indicePasoExistente == -1) {
			throw new RecetaException("No existe ese paso en la lista de pasos");
		} else {
			// Añade en la posicion siguiente al existente el paso nuevo con add
			// (pos,objeto)
			pasos.add(indicePasoExistente + 1, pasoNuevo.toUpperCase());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreReceta == null) ? 0 : nombreReceta.hashCode());
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
		Receta other = (Receta) obj;
		if (nombreReceta == null) {
			if (other.nombreReceta != null)
				return false;
		} else if (!nombreReceta.equalsIgnoreCase(other.nombreReceta))
			return false;
		return true;
	}

}
