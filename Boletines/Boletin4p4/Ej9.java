package Boletin4p4;

import java.util.Scanner;

public class Ej9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase");

		String frase = sc.nextLine();
		sc.close();

		System.out.println(sumaNumeros(frase));
	}

	/**
	 * Método que localizará los numeros y realizará la suma de estos.
	 * @param frase
	 * @return
	 */
	public static int sumaNumeros(String frase) {
		int acum = 0;
		StringBuilder digitos = new StringBuilder();
		// Recorro la frase, recojo los numeros y voy añadiendolos al acumulador. En
		// caso de que nos encontremos con un caracter que no sea un numero borraremos
		// el String de digitos para que nu se vayan añadiendo números que no deberian.
		for (int i = 0; i < frase.length(); i++) {
			if (Character.isDigit(frase.charAt(i))) {
				digitos.append(frase.charAt(i));
			} else {
				if (digitos.length() > 0) {
					acum += Integer.parseInt(digitos.toString());
					digitos.delete(0, digitos.length());
				}
			}
		}

		// En caso de que la frase acabe en un número, se realizará la suma de este.
		if (digitos.length() > 0) {
			acum += Integer.parseInt(digitos.toString());
		}
		return acum;
	}

}
