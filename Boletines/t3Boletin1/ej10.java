package t3Boletin1;

import java.util.Arrays;

public class ej10 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1, 3, 3, 5, 6, 6, 7 }; // Si hubiera un 0 daría un fallo a no ser que usemos clase
														// integer en vez de enteros, ya que un nuevo array por defencto
														// esta relleno de ceros y detectaría que ya lo tiene.

		System.out.println(Arrays.toString(eliminaDuplicados(array))); // muestra el nuevo array.

	}

	private static int[] eliminaDuplicados(int[] numeros) {

		int[] nuevoArray = new int[numeros.length]; // Nuevo array con la longitud de numeros
		int elementosArray = 0; // Posicion del nuevo array, comienza en 0 y va subiendo en 1 si se añade un
								// nuevo elemento.

		for (int elemento : numeros) {

			if (!contieneElemento(nuevoArray, elemento)) {
				nuevoArray[elementosArray++] = elemento;
			}

			// Con esto solucionamos el problema del 0. Primero comprobamos si contenía
			// algun 0 con este if
			if (contieneElemento(numeros, 0)) {
				elementosArray++; // Si lo contiene sumará una posicion al numero de elementos para reservar uno
									// de los ceros que se crean automaticamente en el array vacío.
			}
		}
		//return nuevoArray; este es el antiguo metodo
		return recortaArray(nuevoArray,elementosArray);
	}

	// Cogemos el modulo de contieneElemento del ejercicio 7 para sacar si el numero
	// ya está en el nuevo array o no.
	private static boolean contieneElemento(int[] array, int elemento) {
		// recorremos el array con el for.
		for (int i = 0; i < array.length; i++) {
			if (array[i] == elemento) {
				return true;
			}
		}
		return false;
	}
	
	//Crearemos este nuevo método para solucionar el problema del 0, el cual recortará el Array creando uno nuevo.
	private static int[] recortaArray(int[] array, int longitud) {
		
		int[] arrayRecortado = new int[longitud];
		
		for (int i = 0; i < longitud; i++) {
			arrayRecortado[i] = array[i]; //ponemos en el nuevo los mismos datos y posiciones que en el antiguo.
		}
		return arrayRecortado;
	}
}
