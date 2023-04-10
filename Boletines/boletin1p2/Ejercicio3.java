package boletin1p2;

import java.util.Scanner;

public class Ejercicio3 {
	
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		int contador = 0;
		int numeroIntro = 0;
		
		do {
			System.out.println("Cuántos números va a introducir?");
			contador = Integer.parseInt(teclado.nextLine());
			
			if (contador <= 0) {
				System.out.println("Introduzca un número superior a 0");
			}
	
		} while (contador <= 0);
		
		for (int i = 0; i < contador; i++) {
			
		}
		

	}

}
