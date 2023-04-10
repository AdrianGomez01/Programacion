package boletin1p2;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int num;
		int suma = 0;

		do {
			System.out.println("Introduzca un número");
			num = Integer.parseInt(teclado.nextLine());
		} while (num <= 0);

		teclado.close();

		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				suma = suma + i;
			}
		}

		if (suma == num) {
			System.out.println("El número " + num + " es perfecto");
		} else {
			System.out.println("El número " + num + " no es perfecto");
		}
	}

}
