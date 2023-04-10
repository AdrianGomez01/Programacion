package Tema3.boletinMatrices;

public class ej1 {

	public static void main(String[] args) {

		int matriz[][] = { { 1, 3, 6 }, { 5, 7, -8 } };

		compruebaNegativos(matriz);
	}

	private static boolean compruebaNegativos(int[][] matriz) {
		boolean negativos = false;

		// recorremos todas las filas y cloumnas en busca de algun negativo
		// y comprobamos si lo hay.
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] < 0) {
					negativos = true;
					break; // si encuentra un negativo para.
				}
			}
		}
		return negativos;
	}
}
