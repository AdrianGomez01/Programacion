package Tema7.src.EjemploClaseFile.src;

import java.io.File;
import java.util.Scanner;

public class EjemploClaseFileDirectorio {
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		String nombreCarpetaACrear;
		File directorio;
		boolean creada;
		
		System.out.println("Introduce el nombre de la carpeta que quieres crear:");
		nombreCarpetaACrear= teclado.nextLine();
		
		directorio=new File(nombreCarpetaACrear);
		
		
		if ( directorio.isDirectory()) {
			System.out.println("Ya existe esa carpeta");
		}
		else {
			creada=directorio.mkdirs();
			if (creada) {
				System.out.println("Se ha creado la carpeta");
			}
			else {
				System.out.println("No se pudo crear la carpeta");
			}
		}

	}

}
