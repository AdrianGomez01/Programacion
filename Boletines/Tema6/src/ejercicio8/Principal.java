package Tema6.src.ejercicio8;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	private static final int OPCION_SALIR = 7;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		FlotaVehiculos flotaVehiculos;

		try {
			flotaVehiculos = new FlotaVehiculos();
			Furgoneta v1 = new Furgoneta("1234ABC", TipoGama.ALTA, 1500);
			Furgoneta v2 = new Furgoneta("3124LLB", TipoGama.MEDIA, 900);
			Furgoneta v3 = new Furgoneta("9764AAB", TipoGama.BAJA, 2000);
			Coche v4 = new Coche("9431GDZ", TipoGama.ALTA, TipoCombustible.DIESEL);
			Coche v5 = new Coche("2297ANB", TipoGama.ALTA, TipoCombustible.GASOLINA);
			Coche v6 = new Coche("8566BZE", TipoGama.BAJA, TipoCombustible.GASOLINA);
			Microbus v7 = new Microbus("2463ÑÑP", TipoGama.BAJA, 15);
			Microbus v8 = new Microbus("1974LLO", TipoGama.MEDIA, 10);
			Microbus v9 = new Microbus("6471UOR", TipoGama.ALTA, 20);

			flotaVehiculos.introducirVehiculo(v1);
			flotaVehiculos.introducirVehiculo(v2);
			flotaVehiculos.introducirVehiculo(v3);
			flotaVehiculos.introducirVehiculo(v4);
			flotaVehiculos.introducirVehiculo(v5);
			flotaVehiculos.introducirVehiculo(v6);
			flotaVehiculos.introducirVehiculo(v7);
			flotaVehiculos.introducirVehiculo(v8);
			flotaVehiculos.introducirVehiculo(v9);
			do {
				opcion = mostrarMenu();
				tratarMenu(opcion, flotaVehiculos);

			} while (opcion != OPCION_SALIR);
		} catch (VehiculoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void tratarMenu(int opcion, FlotaVehiculos flotaVehiculos) {
		Vehiculo vehiculo;
		String matricula;
		int dias;
		double precioAlquiler;

		try {
			switch (opcion) {
			case 1: {
				vehiculo = elegirTipoVehiculo();
				flotaVehiculos.introducirVehiculo(vehiculo);
				break;
			}
			case 2: {

				matricula = introduceMatricula();
				dias = solicitarDias();
				precioAlquiler = flotaVehiculos.precioAlquiler(matricula, dias);

				System.out.println("El vehículo con la matricula " + matricula + " tiene que pagar por alquiler "
						+ precioAlquiler);

				break;

			}
			case 3: { // consulta de todos los vehículos ordenados por matricula
				mostrarVehiculosOrdenadosPorMatricula(flotaVehiculos);
				break;
			}

			case 4: { // consulta de todos las furgonetas ordenadas por pma
				mostrarFurgonetasOrdenadasPorPma(flotaVehiculos);
				break;
			}

			case 5: { // consulta de todos los vehículos ordenados por gama{
				mostrarVehiculosOrdenadosPorGama(flotaVehiculos);
				break;
			}
			case 6: { // consulta de todos los vehículos ordenados por gama{
				mostrarVehiculosFiltradosPorAlquiler(flotaVehiculos);
				break;
			}
			}

		} catch (VehiculoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static int solicitarDias() {

		int dias = -1;

		do {
			try {
				System.out.println("Introduce el número de dias que el vehiculo ha estado alquilado");

				dias = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero positivo");
			}

		} while (dias < 0);

		return dias;
	}

	private static double solicitarPrecioMin() {

		int precio = -1;

		do {
			try {
				System.out.println("Introduce el precio minimo a filtrar");

				precio = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero positivo");
			}

		} while (precio < 0);

		return precio;
	}

	private static Vehiculo elegirTipoVehiculo() throws VehiculoException {
		Vehiculo vehiculo = null;
		String tipoVehiculo;
		String matricula;
		TipoGama gama;
		TipoCombustible combustible;
		int numPlazas;
		int pma;

		tipoVehiculo = solicitarTipoVehiculo();

		matricula = introduceMatricula();
		gama = introduceGama();

		switch (tipoVehiculo) {
		case "COCHE": {

			combustible = introduceCombustible();
			vehiculo = new Coche(matricula, gama, combustible);
			break;
		}
		case "MICROBUS": {
			System.out.println("N�mero de plazas que tiene");
			numPlazas = Integer.parseInt(teclado.nextLine());
			vehiculo = new Microbus(matricula, gama, numPlazas);

			break;
		}
		case "FURGONETA": {
			System.out.println("Introduce el peso m�nimo autorizado del veh�culo");
			pma = Integer.parseInt(teclado.nextLine());
			vehiculo = new Furgoneta(matricula, gama, pma);

			break;
		}

		}

		return vehiculo;

	}

	private static String solicitarTipoVehiculo() {
		String tipoVehiculo;
		do {
			System.out.println("Que tipo de veh�culo va a dar de alta: Coche, Microbus, Furgoneta");
			tipoVehiculo = teclado.nextLine().toUpperCase();

		} while (!(tipoVehiculo.equals("COCHE") || tipoVehiculo.equals("MICROBUS")
				|| tipoVehiculo.equals("FURGONETA")));

		return tipoVehiculo;
	}

	private static String introduceMatricula() {
		String matricula;

		System.out.println("Introduce matrícula");
		matricula = teclado.nextLine().toUpperCase();
		return matricula;
	}

	private static TipoGama introduceGama() {
		TipoGama gama = null;
		String cadena;
		boolean correcto = false;

		do {
			System.out.println("Introduce gama a la que pertenece " + Arrays.toString(TipoGama.values()));
			cadena = teclado.nextLine().toUpperCase();
			try {
				gama = TipoGama.valueOf(cadena);
				correcto = true;
			} catch (IllegalArgumentException e) {
				System.out.println("No ha introducido una gama correcta");
			}

		} while (correcto == false);

		return gama;

	}

	private static TipoCombustible introduceCombustible() {
		TipoCombustible combustible = null;
		String cadena;
		boolean correcto = false;
		do {
			System.out.println("Tipo de combustible que usa:" + Arrays.toString(TipoCombustible.values()));
			cadena = teclado.nextLine().toUpperCase();
			try {
				combustible = TipoCombustible.valueOf(cadena);
				correcto = true;
			} catch (IllegalArgumentException e) {
				System.out.println("No ha introducido un combustible correcto");
			}

		} while (correcto == false);

		return combustible;
	}

	// M�todo mostrar menu
	private static int mostrarMenu() {
		int op = 0;
		do {
			System.out.println(" ");
			System.out.println("Menú vehículos:");
			System.out.println("1.-Alta vehículo");
			System.out.println("2.-Precio Alquiler");
			System.out.println("3.-Consultar Vehiculos ordenados por matrícula ");
			System.out.println("4.-Consultar furgonetas ordenados por PMA");
			System.out.println("5.-Consultar vehiculos ordenados por gama");
			System.out.println("6.-Consultar Vehiculos filtrados por precio de alquiler minimo");
			System.out.println("7.-Salir");
			System.out.println(" ");
			// System.lineSeparator();
			try {
				op = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un n�mero de 1 al " + OPCION_SALIR);
			}
		} while (op < 1 || op > OPCION_SALIR);

		return op;
	}

	private static void mostrarVehiculosOrdenadosPorMatricula(FlotaVehiculos flotaVehiculos) {
		flotaVehiculos.listadoOrdenadoPorMatricula().forEach(System.out::println);
	}

	private static void mostrarFurgonetasOrdenadasPorPma(FlotaVehiculos flotaVehiculos) {
		flotaVehiculos.listadoOrdenadoPorPma().forEach(System.out::println);
	}

	private static void mostrarVehiculosOrdenadosPorGama(FlotaVehiculos flotaVehiculos) {
		flotaVehiculos.listadoVehiculosOrdenadoPorGama().forEach(System.out::println);
	}

	private static void mostrarVehiculosFiltradosPorAlquiler(FlotaVehiculos flotaVehiculos) throws VehiculoException {
		int dias = solicitarDias();
		double precioMin = solicitarPrecioMin();
		flotaVehiculos.listadoFiltradoPorAlquiler(dias, precioMin).forEach(v -> {
			try {
				System.out.printf("%s: %.2f\n", v, v.calcularAlquiler(dias));
			} catch (VehiculoException e) {

				e.printStackTrace();
			}

		});
	}

}
