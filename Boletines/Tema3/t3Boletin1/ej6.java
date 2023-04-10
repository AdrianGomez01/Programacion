package Tema3.t3Boletin1;

import java.util.Arrays;
import java.util.Random;

public class ej6 {

	public static final int NUM_INICIAL = 0;
	public static final int NUM_FINAL = 10;
	public static final int NUM_BUSCADO = 2;
	
	public static void main(String[] args) {

		int[] numeros = new int[10];
		boolean encontrado = false;

		// usaremos en este caso la variable random para generar un numero aleatorio
		Random aleatorio;
		aleatorio = new Random();

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = aleatorio.nextInt(NUM_FINAL); // no incluiría el 10, para ello habria que sumarle 1 a num_final
		}

		System.out.printf("Los numeros aleatorios son: %s", Arrays.toString(numeros));

		for (int i = 0; i < numeros.length && !encontrado; i++) { // !encontrado es lo mismo que encontrado == false
			if (numeros[i] == NUM_BUSCADO) {
				encontrado = true;
			}
		}

		System.out.println(); //salto de linea
		
		if (encontrado == true) {
			System.out.println("El elemento se ha encontrado" );
		} else {
			System.out.println("El elemento NO se ha encontrado" );
		}
		
	}
}
