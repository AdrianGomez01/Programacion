package Tema1.boletin1p2;

import java.util.Scanner;

public class Ejercicio5 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero = 0;
		int contador = 0;

		do {
			System.out.println("Introduzca un número (negativo para acabar)");
			numero = Integer.parseInt(teclado.nextLine());
			contador++;

		} while (numero >= 0);
		teclado.close();
		
		System.out.println("Has introducido " + --contador + " números positivos");

	}

}
