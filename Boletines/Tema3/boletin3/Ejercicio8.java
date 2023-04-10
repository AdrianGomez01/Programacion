package Tema3.boletin3;

import java.util.Scanner;

public class Ejercicio8 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numA, numB, numC; // declaramos las variables de los coeficientes

		System.out.println("Introduzca el primer coeficiente");
		numA = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el segundo coeficiente)");
		numB = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el tercer coeficiente)");
		numC = Integer.parseInt(teclado.nextLine());

		teclado.close();

		// Declaramos una variable para el discriminante con la ecuación

		double discriminante = (Math.pow(numB, 2) - (4 * numA * numC));

		// Comprobamos el tamaño del disciminante. Dependiendo de si es mayor, igual o
		// menor que 0 sabremos la cantidad de soluciones.
		if (discriminante == 0 || discriminante > 0) {
			if (discriminante == 0) {
				System.out.println("Solo hay 1 solución");
			} else {
				System.out.println("Hay 2 soluciónes");
			}
		} else {
			System.out.println("No hay soluciones");
		}
	}

}
