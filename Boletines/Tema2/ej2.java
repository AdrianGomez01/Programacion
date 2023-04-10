package Tema2;

import java.util.Scanner;

public class ej2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("introduzca un número");
		int num = Integer.parseInt(teclado.nextLine());
		int numOg = num;
		int result = 0;

		teclado.close();

		// Se divide entre 10 y así vamos sacando las cifras una a una

		while (num != 0) {
			int resto = num % 10;
			result = result * 10 + resto;
			num = num / 10;
		}
		
		if (numOg == result) {
			System.out.println("El número es capicúa");
		} else {
			System.out.println("El número NO es capicúa");
		}

		System.out.printf("La inversa de %d es %d", numOg, result);

	}
}
