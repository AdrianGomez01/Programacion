package Tema1.boletin1p2;

import java.util.Scanner;

public class Ejercicio6 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero1;
		int numero2;
		int temp;
		int producto = 0;
		int contador;

		System.out.println("Introduzca el primer número");
		numero1 = Integer.parseInt(teclado.nextLine());

		System.out.println("Introduzca el segundo número");
		numero2 = Integer.parseInt(teclado.nextLine());

		teclado.close();

		// Cambio el orden de los números para que sea más rapido en el caso de
		// multiplicar grandes cantidades.

		if (numero1 > numero2) {
			temp = numero1;
			numero1 = numero2;
			numero2 = temp;
		}

		for (contador = 1; contador <= numero2; contador++) {
			producto = producto + numero1;
		}

		System.out.println("El producto de " + numero1 + " entre " + numero2 + " es igual a " + producto);

	}

}
