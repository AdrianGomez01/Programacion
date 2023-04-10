package boletin3;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int num1;
		int num2;
		int num3;

		System.out.println("Introduzca un número");
		num1 = Integer.parseInt(teclado.nextLine());

		System.out.println("Introduzca un número");
		num2 = Integer.parseInt(teclado.nextLine());

		System.out.println("Introduzca un número");
		num3 = Integer.parseInt(teclado.nextLine());

		teclado.close();

		if (num1 < num2 && num1 < num3) {
			if (num2 < num3) {
				System.out.println(num1 + "<" + num2 + "<" + num3);
			} else {
				System.out.println(num1 + "<" + num3 + "<" + num2);
			}
		} else if (num2 < num1 && num2 < num3) {
			if (num1 < num3) {
				System.out.println(num2 + "<" + num1 + "<" + num3);
			} else {
				System.out.println(num2 + "<" + num3 + "<" + num1);
			}
		} else if (num3 < num1 && num3 < num2) {
			if (num1 < num2) {
				System.out.println(num3 + "<" + num1 + "<" + num2);
			} else {
				System.out.println(num3 + "<" + num2 + "<" + num1);
			}
		}
		/*
		 * Comprobamos en cada IF el orden de los números, dándose 3 casos dependiendo
		 * de qué número sea el que ocupe la primera posición
		 */
	}

}
