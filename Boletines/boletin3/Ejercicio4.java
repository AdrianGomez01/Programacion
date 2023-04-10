package boletin3;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

	private static final int NUM_INICIAL = 1;
	private static final int NUM_FINAL = 100;
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random r = new Random();
		//  int numRan = r.nextInt(NUM_INICIAL, NUM_FINAL +1) ;
		
		int numRan = r.nextInt(NUM_FINAL) +1; //solo ponemos el numero final porque al ser entero no va a ser inferior a 0
		int num=1;
	
		
		if (num>=NUM_INICIAL || num<=NUM_FINAL) {
			do {
				System.out.printf("Introduzca un número entre %d y %d", NUM_INICIAL, NUM_FINAL);
				num = Integer.parseInt(teclado.nextLine());
			} while (!(num == numRan));
		} else {
			System.out.printf("ERROR, EL NUMERO DEBE ESTAR ENTRE 1 Y 100");
		}
			
		
		
		
		teclado.close();
	}

}
