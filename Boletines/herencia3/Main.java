package herencia3;

import java.util.Arrays;
import java.util.Iterator;

public class Main implements CreableEstadisticas {

	private static final int MAX_PERSONAJES = 3;
	private Personaje[] personajes = new Personaje[MAX_PERSONAJES];

	public static void pepe(String[] args) {
		try {
			Mago magoA = new Mago("Pepe", TRaza.ELFO, 14, 18, 40);
			Mago magoB = new Mago("Juan", TRaza.ENANO, 12, 20, 30);
			Clerigo clerigoA = new Clerigo("Gerardo", TRaza.ORCO, 19, 14, 60, "Pedro");
			System.out.println(magoA.toString());
			System.out.println(magoB.toString());
			System.out.println(clerigoA.toString());
			magoA.aprenderHechizo("Lumus");
			magoA.aprenderHechizo("Espectro Patronum");
			magoB.aprenderHechizo("Alohomora");
			System.out.println(magoA.toString());
			System.out.println(magoB.toString());
			magoA.lanzarHechizo(magoB, "Lumus");
			magoB.lanzarHechizo(magoA, "Alohomora");
			clerigoA.curar(magoB);
			magoA.lanzarHechizo(magoB, "Espectro Patronum");
			System.out.println(magoA.toString());
			System.out.println(magoB.toString());
			System.out.println(clerigoA.toString());

		} catch (PersonajeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		int opcion = 0;
		Main juego = new Main();
		Personaje[] personajes = juego.getPersonajes();
		do {
			try {

				System.out.println(menu());
				opcion = MiEntradaSalida.leerEnteroEnRango("Escriba una opcion", 1, 7);
				switch (opcion) {
				case 1:
					boolean introducido = false;
					for (int i = 0; i < personajes.length; i++) {
						if (personajes[i] == null) {
							personajes[i] = crearPersonaje();
							introducido = true;
							break;
						}
					}
					if (!introducido) {
						System.out.println("No puede introducir mas personajes");
					}
					break;
				case 2:
					String nombreMago = MiEntradaSalida.solicitarCadena("Escriba el nombre del mago");

					for (int i = 0; i < personajes.length; i++) {
						if (personajes[i] instanceof Mago) {
							if (personajes[i].getNombre().equals(nombreMago)) {
								String nombreHechizo = MiEntradaSalida.solicitarCadena("Escriba el nombre del hechizo");
								((Mago) personajes[i]).aprenderHechizo(nombreHechizo);
							}
						}
					}
					break;
				case 3:
					int posicionMago = -1;
					nombreMago = MiEntradaSalida.solicitarCadena("Escriba el nombre del mago que contiene el hechizo");
					String nombreVictima = MiEntradaSalida
							.solicitarCadena("Escriba el nombre del personaje que sufre el hechizo");

					for (int i = 0; i < personajes.length; i++) {
						if (nombreMago.equals(personajes[i].getNombre()) && posicionMago == -1) {
							if (!personajes[i].comprobarMuerte()) {
								posicionMago = i;
								for (int j = 0; j < personajes.length; j++) {
									if (nombreMago.equals(nombreVictima)) {
										System.out.println("El personaje no puede pegarse a sí mismo.");
									} else {
										if (nombreVictima.equals(personajes[i].getNombre()) && posicionMago != -1) {
											if (!personajes[j].comprobarMuerte()) {
												String nombreHechizo = MiEntradaSalida
														.solicitarCadena("Escriba el nombre del hechizo");
												((Mago) personajes[posicionMago]).lanzarHechizo(personajes[j],
														nombreHechizo);
												break;
											} else {
												throw new PersonajeException("El personaje esta muerto");
											}
										}
									}
								}
							} else {
								throw new PersonajeException("El personaje esta muerto");
							}
						}
					}
					break;
				case 4:
					String nombreClerigo = MiEntradaSalida.solicitarCadena("Escriba el nombre del clerigo");
					nombreMago = MiEntradaSalida.solicitarCadena("Escriba el nombre del mago a curar ");
					int posicionClerigo = -1;
					for (int i = 0; i < personajes.length; i++) {
						if (nombreClerigo.equals(personajes[i].getNombre()) && posicionClerigo == -1) {
							if (!personajes[i].comprobarMuerte()) {
								posicionClerigo = i;
								for (int j = 0; j < personajes.length; j++) {
									if (nombreClerigo.equals(nombreMago)) {
										System.out.println("El personaje no puede Curarse a sí mismo.");
									} else {
										if (nombreMago.equals(personajes[i].getNombre()) && posicionClerigo != -1) {
											if (!personajes[j].comprobarMuerte()) {
												String nombreHechizo = MiEntradaSalida
														.solicitarCadena("Escriba el nombre del hechizo");
												((Clerigo) personajes[posicionClerigo]).curar(personajes[j]);
												;
												break;
											} else {
												throw new PersonajeException("El personaje esta muerto");
											}
										}
									}
								}
							} else {
								throw new PersonajeException("El personaje esta muerto");
							}
						}
					}

				case 5:
					for (Personaje i : personajes) {
						if (i != null) {
							System.out.println(i);
						}
					}
					break;
				case 6:
					Personaje[] personajesOrdenados = personajes.clone();
					Arrays.sort(personajesOrdenados);
					for (Personaje i : personajesOrdenados) {
						if (i != null) {
							System.out.println(i);
						}
					}

					break;
				case 7:
					System.out.printf("Los PV mas bajos son %.0f \n", juego.minimo());
					System.out.printf("Los PV mas altos son %.0f \n", juego.maximo());
					System.out.printf("La media de PV es %.2f \n", juego.media());
				}	
			} catch (PersonajeException e) {
				System.out.println(e.getMessage());
			}
		} while (opcion > 0 && opcion < 7);

	}

	public Personaje[] getPersonajes() {
		return personajes;
	}

	public static String menu() {
		StringBuilder string = new StringBuilder();
		string.append("Elige una opción: ").append("\n");
		string.append("1. Alta de personaje. ").append("\n");
		string.append("2. Mago aprende hechizo. ").append("\n");
		string.append("3. Mago lanza hechizo. ").append("\n");
		string.append("4. Clérigo cura mago. ").append("\n");
		string.append("5. Lista de personajes. ").append("\n");
		string.append("6. Lista personajes por puntos actuales. ").append("\n");
		string.append("7. Estadisticas.").append("\n");
		return string.toString();
	}

	public static Personaje crearPersonaje() throws PersonajeException {
		String opciones[] = { "Mago", "Clerigo" };
		String opcion = MiEntradaSalida.devuelveOpcion("Seleccione alguna de las siguientes clases: \n", opciones);
		Personaje p;
		String nombre = MiEntradaSalida.solicitarCadena("Escriba el nombre del personaje: ");
		int fuerza = MiEntradaSalida.solicitarEnteroPositivo("Escriba la fuerza del personaje: ");
		int inteligencia = MiEntradaSalida.solicitarEnteroPositivo("Escriba la inteligencia del personaje: ");
		int maxPV = MiEntradaSalida.solicitarEnteroPositivo("Escriba la vida maxima del personaje: ");
		boolean correcto = false;
		String raza;
		TRaza razas = null;
		while (!correcto) {
			try {
				raza = MiEntradaSalida
						.solicitarCadena("Introduzca la raza del personaje. " + Arrays.toString(TRaza.values()));
				if (!(raza == null || raza.trim().isEmpty())) {
					razas = TRaza.valueOf(raza);
					correcto = true;
				}

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		if (opcion.equals("Mago")) {
			p = new Mago(nombre, razas, fuerza, inteligencia, maxPV);
		} else {
			String dios = MiEntradaSalida.solicitarCadena("Escriba el nombre del dios: ");
			p = new Clerigo(nombre, razas, fuerza, inteligencia, maxPV, dios);
		}
		return p;
	}

	@Override
	public double minimo() {
		int pvMin = Personaje.PV_MAX;
		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null && personajes[i].getActualPV() < pvMin) {
				pvMin = personajes[i].getActualPV();
			}
		}
		return pvMin;
	}

	@Override
	public double maximo() {
		int pvMax = Personaje.PV_MIN;
		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null && personajes[i].getActualPV() > pvMax) {
				pvMax = personajes[i].getActualPV();
			}
		}
		return pvMax;
	}

	@Override
	public double media() {
		double media = 0;
		int numPersonajes = 0;
		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null) {
				media += personajes[i].getActualPV();
				numPersonajes++;
			}
		}
		return media / numPersonajes;
	}
}
