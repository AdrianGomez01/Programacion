package ejercicio7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Recetario {

	private HashMap<String, Receta> recetas;

	public Recetario() {
		recetas = new HashMap<String, Receta>();

	}

	public void annadirReceta(Receta nuevaReceta) throws RecetaException {

		if (recetas.containsKey(nuevaReceta.getNombreReceta())) {
			throw new RecetaException("La receta ya existe");
		} else {
			// TODO terminar esto
			recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
		}
	}

	/**
	 * Añade a un stringBD un listado de recetas ,ordenado alfabeticamente
	 * 
	 * @return
	 * @throws RecetaException Si no hay recetas
	 */
	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {

		if (recetas.isEmpty()) {
			throw new RecetaException("No hay recetas");
		} else {
			StringBuilder listadoOrdenadoAlf = new StringBuilder();
			List<Receta> listaRecetas = new ArrayList<>(recetas.values());

			listaRecetas.sort(new Comparator<Receta>() {
				public int compare(Receta receta1, Receta receta2) {
					return receta1.getNombreReceta().compareTo(receta2.getNombreReceta());
				}
			});
			for (Receta receta : listaRecetas) {
				listadoOrdenadoAlf.append(receta.getNombreReceta()).append(": ")
						.append(receta.getMinutosDePreparacion()).append(" minutos").append(System.lineSeparator());
			}

			return listadoOrdenadoAlf.toString();
		}
	}

	/**
	 * Método que añade a un SB un listado de recetas que contienen ingredientes,
	 * ordenado de forma asc por el tiempo de preparacion.
	 * 
	 * @param ingrediente - Ingrediente a comprobar
	 * @return
	 * @throws RecetaException
	 */
	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {

		List<Receta> listaRecetasConIng = new ArrayList<>();
		StringBuilder listadoOrdenadoMins = new StringBuilder();
		boolean hayIngrediente = false;

		//Aqui filtramos las recetas ue contengan los ingredientes
		for (Receta receta : recetas.values()) {
			if (receta.necesitaIngrediente(ingrediente)) {
				listaRecetasConIng.add(receta);
				hayIngrediente = true;
			}
		}

		if (!hayIngrediente) {
			throw new RecetaException("No hay recetas con el ingrediente indicado");
		}
		listaRecetasConIng.sort(new Comparator<Receta>() {

			@Override
			public int compare(Receta o1, Receta o2) {
				// Restamos el tiempo de preparacion del primero - el del segundo. Ya que
				// Compare devuelve <0 si va antes el primero, 0 si son iguales , >0 si va antes
				// el segundo.
				return o1.getMinutosDePreparacion() - o2.getMinutosDePreparacion();
			}

		});

		for (Receta receta : listaRecetasConIng) {
			listadoOrdenadoMins.append(receta.getNombreReceta()).append(": ").append(receta.getMinutosDePreparacion())
					.append(" minutos").append(System.lineSeparator());
		}
		return listadoOrdenadoMins.toString();
	}
}
