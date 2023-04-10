package Boletin4p4;

import java.util.Scanner;

public class Ej8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase");
		
		String frase = sc.nextLine();
		sc.close();
		
		System.out.println("En la frase hay " + cuentaPalabras(frase) + " palabras");

	}
	
	public static int cuentaPalabras(String frase) {
		
		String[] palabras = frase.split(" ");
		int contador = 0;
		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i]);
			if (!palabras[i].equals("")) {
				contador++;
			}
		}
		
		return contador;
	}

}
