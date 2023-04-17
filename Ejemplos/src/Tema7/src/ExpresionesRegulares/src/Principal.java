package Tema7.src.ExpresionesRegulares.src;

import java.util.Scanner;

public class Principal {
	
	private static final String PATRON = ".*abc.*";
	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena;
		
		System.out.println("Introduce una cadena: ");
		cadena=teclado.nextLine();
		
		if (cadena.matches(PATRON)) {
			System.out.println("Encaja ");
		}
		else {
			System.out.println("No encaja");
		}

	}

}
