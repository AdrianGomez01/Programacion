package Tema3.boletinMatrices;

public class ej13 {
	public static void main(String[] args) {
		// Declaramos la matriz
		int[][] matriz = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 6, 7, 8, 9, 0 }, 
				{ 3, 2, 1, 4, 5 }, 
				{ 9, 5, 8, 6, 7 },
				{ 0, 9, 8, 5, 4 } 
				};

		// Llamada al metodo y la guardamos para que no se pierda
		int[][] reflejo = reflejoDiagonal(matriz);

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(reflejo[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * comprueba que la matriz sea cuadrada y la refleja e diagonal
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[][] reflejoDiagonal(int[][] matriz) {

		// Declaramos la matriz reflejada en diagonal
		int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
		if (matriz.length == matriz[0].length) {
			// recorremos la matriz con los FOR
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[0].length; j++) {
					// jugamos con los indices de las matrices para ir invirtiendolas.
					nuevaMatriz[i][j] = matriz[matriz.length - 1 - j][matriz.length - 1 - i];
				}
			}
		}

		return nuevaMatriz;
	}

}