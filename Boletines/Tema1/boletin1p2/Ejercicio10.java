package Tema1.boletin1p2;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int num;
		int factorial=1;
		
		do {
			System.out.println("Introduzca un número");
			num = Integer.parseInt(teclado.nextLine());
		} while (num < 0);
		
		for (int i = 2; i <= num; i++) {
			factorial = factorial * i;
		}
		
		System.out.println("El factorial de " + num + " es " + factorial);
		
		teclado.close();
	}

}
