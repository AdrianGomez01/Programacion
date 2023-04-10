package boletinMatrices;

public class ej11 {
	public static void main(String[] args) {

		int[][] matriz1 = { { 5, 8, 9, 0 }, { 4, 7, 5, 2 }, { 1, 7, 3, 2 } };
		int[][] matriz2 = { { 2, 3, 7, 1 }, { 2, 5, 7, 4 }, { 0, 9, 8, 5 } };

		if (esInversa(matriz1, matriz2)) {
			System.out.println("Son inversas");
		} else {
			System.out.println("no son inversas");
		}
	}

	private static boolean esInversa(int[][] matrizA, int[][] matrizB) {
		boolean inversa = true;

		// comprobamos el tamaño de las filas con el IF y las recorremos
		if (matrizA.length == matrizB.length) {
			for (int i = 0; i < matrizA.length && inversa; i++) {
				// comprobamos el tamaño de las columnas con el if y las recorremos
				if (matrizA[i].length == matrizB[i].length) {
					for (int j = 0; j < matrizA[i].length && inversa; j++) {
						/**
						 * recorremos el indice con este IF. Comparamos [i] filas y [j] columnas para
						 * ver si hay alguna distinta inversamente. Aquí matrizB.lenth -1 es la última
						 * posicion, y le vamos restando -i que serian las posiciones de la fila, del
						 * mismo modo lo hacemos con j para las posiciones de las columnas
						 */
						if (matrizA[i][j] != matrizB[matrizB.length - 1 - i][matrizB[0].length - 1 - j]) {
							inversa = false;
						}
					}
				}
			}
		}
		return inversa;
	}
}
