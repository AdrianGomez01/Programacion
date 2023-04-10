package Tema3.boletinMatrices;

public class ej5 {

	public static void main(String[] args) {
		int[][] matriz = { { 1, 2, 3 }, { 5, 6, 7 },

		};

		muestraPorColumnas(matriz);
	}

	public static void muestraPorColumnas(int[][] matriz) {
		// ponemos j para no liarnos con las filas y columnas. J son las filas aqui
		for (int j = 0; j < matriz[0].length; j++) {
			// no especificamos que sea matriz[i] porque la va a recorrer entera
			for (int i = 0; i < matriz.length; i++) {
				System.out.printf("%d ", matriz[i][j]);
			}
		}
	}

}
