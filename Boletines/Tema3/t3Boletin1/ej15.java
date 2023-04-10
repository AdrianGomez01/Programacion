package Tema3.t3Boletin1;

import java.util.Scanner;

public class ej15 {

	public static void main(String[] args) {
		boolean[] eratostenes;
		int ultimoNumero;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el número máximo para saber los primos: ");
		ultimoNumero = Integer.parseInt(sc.nextLine());

		sc.close();

		eratostenes = new boolean[ultimoNumero + 1];

		for (int i = 2; i <= ultimoNumero / 2; i++) {
			if (eratostenes[i] != true) {
				for (int j = 2; j <= (ultimoNumero / i); j++) {
					eratostenes[i * j] = true;
				}
			}
		}

		for (int i = 2; i < eratostenes.length; i++) {
			if (!eratostenes[i]) {
				System.out.printf("%2d ", i);
			}
		}

	}

}
