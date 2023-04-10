package boletin3;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num;
		int acumulador=0;
		
		System.out.println("introduzca un número entero y se determinará el numero de cifras que tiene");
		num = Integer.parseInt(teclado.nextLine());
		
		while (num != 0) {
			num = num /10;
			acumulador++;
		}
		
		System.out.println("El número " + num + " tiene " + acumulador + " cifras");
		
		
		teclado.close();
	}

}
