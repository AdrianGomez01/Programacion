package boletin3;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int base;
		int expo;

		do {
			System.out.println("Introduzca una base");
			base = Integer.parseInt(teclado.nextLine());
		} while (base < 0);

		do {
			System.out.println("Introduzca un exponente");
			expo = Integer.parseInt(teclado.nextLine());
		} while (expo < 0);

		teclado.close();

		int potencia = 0;

		// System.out.printf("La potencia es " + potencia);

	}

}
