package t3Boletin1;

public class ej4 {

	public static final int NUM_INICIAL = 0;
	public static final int NUM_FINAL = 100;
	public static final int CANT_NUM = 6000;
	
	public static void main(String[] args) {
		
		//Variables
		int[] numeros = new int [CANT_NUM];
		int [] terminaciones = new int [10];
		int suma = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			numeros [i] = (int)(Math.random()* (NUM_FINAL - NUM_INICIAL + 1) + NUM_INICIAL);
			//Con el +1 lo que estamos haciendo es añadir el 100 al rango
		}
		
		for (int j = 0; j < numeros.length; j++) {
			int numero = numeros[j];
			suma = suma + numero; //hacemos esto para la media 
			terminaciones[numero%10]++; //con esto sacamos en que numero acaba
		}
		
		double media = (double) suma / numeros.length; //sacamos la media
			System.out.println("La media de los numeros es " + media);
		
		for (int k = 0; k < terminaciones.length; k++) {
			System.out.printf("Numero que terminan en %d : %d. Esto equivale a un %.2f \n", k, terminaciones[k], ((double)terminaciones[k]/numeros.length) * 100);
		}
	}	
}
