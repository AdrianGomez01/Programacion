package Tema7.src.EjemploClaseFile.src;

import java.io.File;
import java.io.IOException;

public class EjemploClaseFile {

	
	public static void main(String[] args) {
		File fichero=new File("hola.txt");
		
		if ( fichero.isFile()) {
			System.out.println("Fichero con tamaño " + fichero.length());
		}
		else {
			
			try {
				fichero.createNewFile();
				System.out.println("Se ha creado el fichero");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
