package boletin1p2;

import java.util.Scanner;

public class Ejercicio2 {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int num;
		
		do {
			System.out.println("Introduce un número del 0 al 10");
			num = Integer.parseInt(teclado.nextLine());
			
		} while ( num < 0 || num > 10);
		
		teclado.close();
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}

	}

}
