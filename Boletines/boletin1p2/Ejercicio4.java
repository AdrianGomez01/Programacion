package boletin1p2;

import java.util.Scanner;

public class Ejercicio4 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero = 0;
		int suma = 0;

		do {
			System.out.println("Introduzca un número positivo");
			numero = Integer.parseInt(teclado.nextLine());

			if (numero <= 0) {
				System.out.println("Error: Introduzca un número superior a 0");
			}

		} while (numero <= 0);

		for (int i = 0; i <= numero; i++) {
			suma = suma + i;
		}
		System.out.println("La suma de los " + numero + " primeros números es " + suma);
	}
}
