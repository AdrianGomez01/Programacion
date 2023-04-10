package Tema1.boletin1;

import java.util.Scanner;

public class Ejercicio9 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		float result = 0;
		System.out.println("Introduzca el precio del producto");
			int precio=Integer.parseInt(teclado.nextLine());
		System.out.println("Introduzca el tipo del producto");
			char tipo=teclado.nextLine().toUpperCase().charAt(0);
			
	//Cierre de teclado
	teclado.close();
	
		if (tipo == 'A' || tipo == 'B' || tipo == 'C') {
			if(tipo == 'A') {
				result = precio - (precio * 0.07f);
				System.out.println("Se le aplica un 7% de descuento");
				System.out.printf("el precio final es de %f ", result);
			}
			else if(tipo == 'C' || precio > 500) {
				result = precio - (precio * 0.12f);
				System.out.println("Se le aplica un 12% de descuento");
				System.out.printf("el precio final es de %f ", result);
			}
			else {
				result = precio - (precio * 0.09f);
				System.out.println("Se le aplica un 9% de descuento");
				System.out.printf("el precio final es de %f ", result);
			}
		}
		else {
			System.out.println("Error");
		}
		
	}

}
