package Tema7.src.ExpresionesRegulares.src;

import java.util.Scanner;

public class SepararParteCadena {
	private static final String PATRON_SEPARACION = "[@. ]+";
	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena;
		String[] partes;
		
		System.out.println("Introduce una cadena: ");
		cadena=teclado.nextLine();
		
		partes=cadena.split(PATRON_SEPARACION);
		
		for (int i = 0; i < partes.length; i++) {
			System.out.println("Parte " + partes[i] + "longitud" + partes[i].length());
		}
		

	}
}
