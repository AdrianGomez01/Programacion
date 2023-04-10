package boletinMatrices;

public class ej3 {

	public static void main(String[] args) {
		int[][] matriz = {
				{1,3,4,5},
				{6,7,8,9},
				{47,99,34,66}
		};
		
		muestraPorFilas(matriz);
	}
	
	public static void muestraPorFilas(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%d ", matriz[i][j]);
			}
		}
	}

}