package boletin3;

import java.util.Scanner;

public class Ejercicio7 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numA, numB,temp;

		// Pedimos los dos números y mostramos un mensaje en caso de error.
		
		do {
			System.out.println("Introduzca el primer numero entero (Mayor que el segundo)");
			numA = Integer.parseInt(teclado.nextLine());
			System.out.println("Introduzca el segundo numero entero (Menor que el primero)");
			numB = Integer.parseInt(teclado.nextLine());

			// Comprobamos que sean mayor que 0 y ponemos el mensaje de error
			
			if (numA <= 0 || numB <= 0) {
				System.out.println("ERROR. Los números introducidos deben ser mayor que 0");
			}
			
			// Comprobamos que el primer número sea mayor que el segundo, en caso contrario
			// muestra el error.
			
			if (numA < numB) {
				System.out.println("ERROR. Debe introducir primero el número MAYOR");
			}
		} while (numA <= 0 || numB <= 0 || numA < numB);

		// Cerramos el teclado
		
		teclado.close();

		// Empleamos el algoritmo de Euclides
		
		while (numB != 0) {
			temp = numA;
			numA = numB;
			numB = temp % numB;
		}

		// Mostramos el resultado
		System.out.printf("El MCD es %d", numA);

	}
}
