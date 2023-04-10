package ficherosDeTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribirFicheroDeTextoPorLineas {
	private static final int NUMERO_LINEAS = 5;
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
	
		String nombreFichero;
		System.out.println("Introduce el nombre del fichero:");
		nombreFichero=teclado.nextLine();
		
		
		escribirEnFicheroPorLineas(nombreFichero);
		
	}
	

	
	private static void escribirEnFicheroPorLineas(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura=new FileWriter(nombre);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			
			
			for (int i = 1; i <= NUMERO_LINEAS; i++) {
				System.out.println("Introduce linea:" + i + " de "+ NUMERO_LINEAS );
				cadena=teclado.nextLine();
				filtroEscritura.println(cadena);
			}
			filtroEscritura.close();
			flujoEscritura.close();			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
