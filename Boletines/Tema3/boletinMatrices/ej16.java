package Tema3.boletinMatrices;

public class ej16 {

	public static void main(String[] args) {
		// se hace con 2 for, quizas dentro un if, para indicar que no puede empezar por
		// la columna anterior a la primera, ya que empieza en la anteriorr

		// creamos matriz
		int matriz[][] = { 	{ 1, 2, 3, 4, 5 }, 
							{ 6, 7, 8, 9, 0 }, 
							{ 3, 2, 1, 4, 5 }, 
							{ 9, 5, 8, 6, 7 },
							{ 0, 9, 8, 5, 4 } };

		pintaMatriz(matriz);
		pintaMatriz(devuelvePares(matriz));

	}

	private static int[][] devuelvePares(int[][] matriz) {
		// Aqui guardaremos el num de pares que tiene cerca el numero
		int numPares = 0;
		// creamos una nueva matriz del mismo tamaño
		int nuevaMatriz[][] = new int[matriz.length][matriz[0].length];
		// recorremos las filas
		for (int i = 0; i < matriz.length; i++) {
			// recorremos las columnas
			for (int j = 0; j < matriz[0].length; j++) {
				// Con esto le indicamos donde empieza a recorrer la matriz alrededor del numero
				// (fila) & comprueba solo los limites de la matriz
				for (int f = i - 1; f <= i + 1 && f < matriz.length; f++) {
					if (f < 0) {
						continue;
					}
					// con esto le indicamos donde acaba de recorrer la matriz al rededor del numero
					// (columna)
					for (int c = j - 1; c <= j + 1 && c < matriz[f].length; c++) {
						// Si está en la posicion del numero que buscamos, se lo salta
						if (i == f && j == c) {
							continue;
						}
						// Borde superior o izquierda
						if (c < 0 || f < 0) {
							continue;
						}
						// si es par suma 1 al num de pares alrededor.
						if (matriz[f][c] % 2 == 0) {
							numPares++;
						}
					}
				}
				// le asignamos el valor a la casilla del num de pares que tiene alrededor
				nuevaMatriz[i][j] = numPares;
				// reiniciamos a 0 para que no se acumulen.
				numPares = 0;
			}
		}
		return nuevaMatriz;
	}

	private static void pintaMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
}
