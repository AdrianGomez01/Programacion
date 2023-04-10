package Tema6.src.ejercicio8;

import java.util.HashMap;
import java.util.List;

public class FlotaVehiculos {

	private HashMap<String, Vehiculo> vehiculos;

	/**
	 * Variable que guarda donde se insertará el siguiente vehiculo Empieza con 0 y
	 * si vale vehiculos.length el almacen esta lleno
	 */
	private int numeroRealDeVehiculos;

	public FlotaVehiculos() throws VehiculoException {
		vehiculos = new HashMap<>();
		numeroRealDeVehiculos = 0;
	}

	public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {

		if (vehiculos.containsKey(vehiculo.getMatricula())) {
			throw new VehiculoException("El vehiculo especificado ya ha sido introducido");
		} else {
			vehiculos.put(vehiculo.getMatricula(), vehiculo);
			numeroRealDeVehiculos++;
		}

	}

	private Vehiculo buscarMatricula(String matricula) {
		return vehiculos.get(matricula);
	}

	public double precioAlquiler(String matricula, int dias) throws VehiculoException {
		Vehiculo v = buscarMatricula(matricula);

		if (v == null) {
			throw new VehiculoException("El vehiculo introducido no existe");
		}

		return v.calcularAlquiler(dias);

	}

	public List<Vehiculo> listadoOrdenadoPorMatricula() {
		return vehiculos.values().stream().sorted((v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula())).toList();
	}

	public List<Furgoneta> listadoOrdenadoPorPma() {
		return vehiculos.values().stream()
				// .filter(v -> v instanceof Furgoneta) - Vale cualquiera de las dos formas.
				.filter(Furgoneta.class::isInstance).map(v -> (Furgoneta) v)
				.sorted((f1, f2) -> f1.getPma() - f2.getPma()).toList();
	}

	public List<Vehiculo> listadoVehiculosOrdenadoPorGama() {
		return vehiculos.values().stream().sorted((v1, v2) -> v1.getGama().compareTo(v2.getGama())).toList();

		// Otra forma de hacer lo mismo, devolviendolo en el orden en el que estan
		// declarados los Enum --
		// vehiculos.values().stream().sorted(Comparator.comparing(Vehiculo::getGama)).toList();

		/*
		 * Esta forma devuelve una lista de TipoGama, y el orden natural es el orden en
		 * el que estan declarados los Enum. return
		 * vehiculos.values().stream().map(Vehiculo::getGama)
		 * .sorted(Enum::compareTo).toList();
		 */
	}

	public List<Vehiculo> listadoFiltradoPorAlquiler(int dias, double precioMin) throws VehiculoException {

		return vehiculos.values().stream().filter(v -> {
			boolean esMayor = false;
			try {
				esMayor = v.calcularAlquiler(dias) > precioMin;
			} catch (VehiculoException e) {
				e.printStackTrace();
			}
			return esMayor;
		}).sorted((v1, v2) -> {
			try {
				// Esta forma no funcionaría si la diferencia fueran solo decimales, ya que
				// convierte a int.
				// return (int) (v1.calcularAlquiler(dias) - v2.calcularAlquiler(dias));
				return Double.compare(v2.calcularAlquiler(dias), v1.calcularAlquiler(dias));
			} catch (VehiculoException e) {
				e.printStackTrace();
			}
			return dias;
		}).toList();
	}

	public String toString() {
		return null;
	}

}
