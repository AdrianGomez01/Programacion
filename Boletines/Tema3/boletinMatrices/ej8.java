package Tema3.boletinMatrices;

public class ej8 {

	public static void main(String[] args) {
		int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] m2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		imprimeMatriz(sumaMatrices(m1, m2));

	}

	/**
	 * Suma 2 matrices, comprobando antes que tienen el mismo tama�o.
	 * 
	 * @param m1 matriz bidimensional
	 * @param m2 matriz bidimensional
	 * @return una nueva matriz con la suma de los valores de m1 y m2. Una matriz
	 *         vac�a del tama�o de m1 en caso de que las matrices no tengan el mismo
	 *         tama�o
	 */
	public static int[][] sumaMatrices(int[][] m1, int[][] m2) {

		/*
		 * Inicializamos resultado con el tama�o de m1. Si todo es correcto, las 2
		 * matrices deben tener el mismo tama�o. Si no, se devuelve todo a 0.
		 */
		int[][] resultado = new int[m1.length][m1[0].length];
		/*
		 * Primero comprobamos que sean del mismo tama�o. Podemos suponer que todas las
		 * filas tienen el mismo n�mero de columnas, o comprobar el n� de columnas fila
		 * por fila. Tal y como hemos comentado en clase, nosotros supondremos que todas
		 * las filas tienen el mismo n�mero de columna.
		 */
		if (m1.length == m2.length) {
			// Si llega aqu�, las matrices tienen el mismo n�mero de filas
			if (m1[0].length == m2[0].length) {
				/*
				 * La primera fila tiene el mismo n�mero de columnas. Para nosotros, esto
				 * significa que las matrices ya son del mismo tama�o. Ahora, sumaremos los
				 * valores de cada posici�n y lo guardaremos en la misma posici�n de la matriz
				 * resultado
				 */
				for (int i = 0; i < m1.length; i++) {
					for (int j = 0; j < m1[0].length; j++) {
						resultado[i][j] = m1[i][j] + m2[i][j];
					}
				}
			}
		}

		return resultado;
	}

	/**
	 * Imprime por consola una matriz de enteros
	 * 
	 * @param matriz
	 */
	public static void imprimeMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%2d ", matriz[i][j]);
			}
			System.out.println();
		}
	}

}