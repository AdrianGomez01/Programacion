package Tema3.boletin3;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int num;

		System.out.println("introduzca un número");
		num = Integer.parseInt(teclado.nextLine());

		teclado.close();

		boolean encontrado = false;

		for (int i = 2; i <= num / 2 && encontrado == false; i++) {
			if (num % i == 0) {
				encontrado = true;
			}
		}

		if (encontrado == true) {
			System.out.println("El número NO es primo");
		} else {
			System.out.println("El número es primo");
		}
	}

}
