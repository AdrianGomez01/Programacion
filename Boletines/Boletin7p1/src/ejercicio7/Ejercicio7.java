package Boletin7p1.src.ejercicio7;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Ejercicio7 {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;
		do {
			System.out.println("MENÚ DE OPCIONES");
			System.out.println("1. Listar directorio");
			System.out.println("2. Listar directorio y buscar ficheros que comiencen por una palabra");
			System.out.println("3. Listar archivos con cierta extensión de un directorio");
			System.out.println("4. Buscar un archivo en un directorio");
			System.out.println("5. Buscar recursivamente un archivo en un directorio");
			System.out.println("5. Buscar recursivamente un archivo en un directorio");
			System.out.println("6. Salir");
			System.out.print("Elija una opción: ");
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
				case 1 -> listarDirectorio();
				case 2 -> listarDirectorioComienzanCon();
				case 3 -> listarDirectorioPorExtension();
				case 4 -> buscarArchivoEnDirectorio();
				case 5 -> buscarArchivoRecursivamente();
				case 6 -> System.out.println("Saliendo...");
				default -> System.out.println("Opción inválida");
			}
		} while (opcion != 6);

	}

	private static void buscarArchivoRecursivamente() {

	}

	private static void buscarArchivoEnDirectorio() {
		System.out.println("Introduzca el nombre del directorio o la ruta absoluta");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el nombre exacto del fichero");
		String palabra = sc.nextLine();
		File directorio = new File(nombre);
		if (directorio.exists()) {
			if (directorio.isDirectory()) {
				if (directorio.canRead()) {
					File[] ficheros = directorio.listFiles();
					if (ficheros != null) {
						for (File fichero : ficheros) {
							if (fichero.getName().equalsIgnoreCase(palabra)) {
								if (fichero.isFile()) {
									System.out.println(fichero.getPath() + " " + (double) fichero.length() / 1024 + "KB");
								} else {
									System.out.println(fichero.getName() + "es un directorio o acceso directo");
								}
							}
						}
					}
				} else {
					System.out.println("El directorio no tiene permisos de lectura");
				}
			} else {
				System.out.println("No se encuentra el directorio con el nombre especificado");
			}
		} else {
			System.out.println("El directorio no existe");
		}

	}

	private static void listarDirectorioPorExtension() {
		System.out.println("Introduzca el nombre del directorio o la ruta absoluta");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la extension del fichero");
		String palabra = sc.nextLine();
		File directorio = new File(nombre);
		if (directorio.exists()) {
			if (directorio.isDirectory()) {
				if (directorio.canRead()) {
					File[] ficheros = directorio.listFiles((dir, name) -> name.endsWith(palabra));
					if (ficheros != null) {
						for (File fichero : ficheros) {
							if (fichero.getName().endsWith(palabra)) {
								if (fichero.isFile()) {
									System.out.println(fichero.getName() + " " + (double) fichero.length() / 1024 + "KB");
								} else {
									System.out.println(fichero.getName() + "es un directorio o acceso directo");
								}
							}
						}
					}
				} else {
					System.out.println("El directorio no tiene permisos de lectura");
				}
			} else {
				System.out.println("No se encuentra el directorio con el nombre especificado");
			}
		} else {
			System.out.println("El directorio no existe");
		}
	}

	private static void listarDirectorioComienzanCon() {
		System.out.println("Introduzca el nombre del directorio o la ruta absoluta");
		String nombre = sc.nextLine();
		System.out.println("Introduce el comienzo del nombre de los ficheros");
		String palabra = sc.nextLine();
		File directorio = new File(nombre);
		if (directorio.exists()) {
			if (directorio.isDirectory()) {
				if (directorio.canRead()) {
					// Con lambda:
					// File[] ficheros = directorio.listFiles((dir,name)-> name.startsWith(palabra));
					File[] ficheros = directorio.listFiles(new FilenameFilter() {

						@Override
						public boolean accept(File dir, String name) {
							return name.startsWith(palabra);
						}
					});
					if (ficheros != null) {
						for (File fichero : ficheros) {
							if (fichero.getName().startsWith(palabra)) {
								if (fichero.isFile()) {
									System.out.println(fichero.getName() + " " + (double) fichero.length() / 1024 + "KB");
								} else {
									System.out.println(fichero.getName() + "es un directorio o acceso directo");
								}
							}
						}
					}
				} else {
					System.out.println("El directorio no tiene permisos de lectura");
				}
			} else {
				System.out.println("No se encuentra el directorio con el nombre especificado");
			}
		} else {
			System.out.println("El directorio no existe");
		}

	}

	private static void listarDirectorio() {
		System.out.println("Introduzca el nombre del directorio o la ruta absoluta");
		String nombre = sc.nextLine();
		File directorio = new File(nombre);
		if (directorio.exists()) {
			if (directorio.isDirectory()) {
				if (directorio.canRead()) {
					File[] ficheros = directorio.listFiles();
					if (ficheros != null) {
						for (File fichero : ficheros) {
							if (fichero.isFile()) {
								System.out.println(fichero.getName() + " " + (double) fichero.length() / 1024 + "KB");
							} else {
								System.out.println(fichero.getName() + "es un directorio o acceso directo");
							}
						}
					}
				} else {
					System.out.println("El directorio no tiene permisos de lectura");
				}
			} else {
				System.out.println("No se encuentra el directorio con el nombre especificado");
			}
		} else {
			System.out.println("El directorio no existe");
		}

	}

}
