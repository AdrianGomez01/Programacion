package Tema3.t3Boletin1;

public class ej8 {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4 };
		int posicion = encuentraPosicion(array, 1); // el 1 es lo que busca

		if (posicion == -1) {
			System.out.println("El elemento no se encuentra en el array");
		} else {
			System.out.printf("El elemento se encuentra en la posicion %d", posicion);
		}

	}

	// Sacamos la posicion.
	private static int encuentraPosicion(int[] array, int i) {

		int pos = -1;

		for (int j = 0; j < array.length; j++) {
			if (array[j] == i) {
				pos = j;
			}
		}
		return pos;
	}
}
