package Tema1.boletin1;

import java.util.Scanner;

public class Ejercicio1 {
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Introduce un número");
		int numero = Integer.parseInt(teclado.nextLine());
		
		if (numero % 2 == 0) {
			System.out.println("El número es par");
		}
		else {
			System.out.println("El número es impar");
		}
	}

}
