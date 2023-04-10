package boletin1;

import java.util.Scanner;

public class Ejercicio8 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Introduce la primera hora");
			int hora1 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce los primeros minutos");
			int minuto1 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce los primeros segundos");
			int segundo1 = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce la segunda hora");
			int hora2 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce los segundos minutos");
			int minuto2 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce los segundos segundos");
			int segundo2 = Integer.parseInt(teclado.nextLine());
		
		//Cierre de teclado
		teclado.close();
		
		if (hora1>hora2) {
			System.out.println("La primera hora es mayor");
		} else if (hora1<hora2) {
			System.out.println("La segunda hora es mayor");
		}else {
			
			if (minuto1>minuto2) {
				System.out.println("La primera hora es mayor");
			} else if (minuto1<minuto2) {
				System.out.println("La segunda hora es mayor");
			}else { 
				
				if (segundo1>segundo2) {
					System.out.println("La primera hora es mayor");
				} else if (segundo1<segundo2) {
					System.out.println("La segunda hora es mayor");
				} else {
					System.out.println("Las dos horas introducidas son iguales");
				}		
					}
			}
				
	}
}
