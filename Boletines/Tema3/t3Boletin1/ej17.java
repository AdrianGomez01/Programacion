package Tema3.t3Boletin1;

public class ej17 {

	public static void main(String[] args) {
		int[][] primeraMatriz = { { 1, 2, 3 }, { 9, 8, 6 } };
		int[][] segundaMatriz = { { 1, 4, 5 }, { 2, 3, 4 } };

		copiaMatriz(primeraMatriz, segundaMatriz);

		// con este for recorremos el array
		for (int i = 0; i < segundaMatriz.length; i++) {
			for (int j = 0; j < segundaMatriz[0].length; j++) {
				System.out.printf("%4d", segundaMatriz[i][j]);
			}
			System.out.println();
		}

	}

	public static void copiaMatriz(int primeraMatriz[][], int segundaMatriz[][]) {
		if (primeraMatriz.length != segundaMatriz.length || primeraMatriz[0].length != segundaMatriz[0].length) {
			System.out.println("Las matrices son de distinto tamaño, no se pueden copiar");
		} else {
			for (int i = 0; i < segundaMatriz.length; i++) {
				for (int j = 0; j < segundaMatriz[0].length; j++) {
					segundaMatriz[i][j] = primeraMatriz[i][j];
					// i son filas, j columnas, copiamos todo.
				}
			}
		}
	}

}
