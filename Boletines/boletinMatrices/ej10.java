package boletinMatrices;

public class ej10 {

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 3, 1 }, { 4, 2, 2, 4 }, { 4, 2, 2, 4 }, { 1, 3, 3, 1 } };

		System.out.println("El resultado es " + esSimetrica(m));
	}

	private static boolean esSimetrica(int[][] matriz) {
		boolean esSimetrica = true;

		// empezamos en matriz[0] porque aún no hemos empezado a recorrer las filas, así
		// que no sabemos ni siquiera si hay una, de este modo recorremos todas las
		// columnas de la fila 0 y sigue
		for (int j = 0; j < matriz[0].length / 2 && esSimetrica; j++) {
			for (int i = 0; i < matriz.length && esSimetrica; i++) {
				if (matriz[i][j] != matriz[i][matriz[0].length - 1 - j]) {
					esSimetrica = false;
				}
			}
		}

		return esSimetrica;
	}

}