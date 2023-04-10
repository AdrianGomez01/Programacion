package Tema2;

import java.util.Scanner;

public class ej3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		char Rom;

		
			System.out.println("introduzca un número romano");
			Rom = teclado.nextLine().toUpperCase().charAt(0);
			
			teclado.close();
			
			//COMO HAGO PARAA SEPARAR LETRA A LETRA EL NUMERO EN LETRAS COMO CON LOS NUMEROS.
			
			if (Rom == 'M' || Rom == 'D' || Rom == 'C' || Rom == 'L' || Rom == 'X' || Rom == 'V' || Rom == 'I');
			
				if (Rom == 'M') {
					int numRom = 1000;
				}
				if (Rom == 'D') {
					int numRom = 500;
				}
				if (Rom == 'C') {
					int numRom = 100;
				}
				if (Rom == 'L') {
					int numRom = 50;
				}
				if (Rom == 'X') {
					int numRom = 10;
				}
				if (Rom == 'V') {
					int numRom = 5;
				}
				if (Rom == 'I') {
					int numRom = 1;
				}
			else {
				System.out.println("Error, introduzca un número romano válido");
			}
		
	
	}

}
