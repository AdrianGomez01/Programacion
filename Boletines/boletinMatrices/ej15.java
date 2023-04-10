package boletinMatrices;

public class ej15 {

	public static void main(String[] args) {
		// Declaramos la matriz
		int[][] matriz = { 
				{ 1,   2,  3,  4,  5,  6 }, 
				{ 7,   8,  9, 10, 11, 12 }, 
				{ 13, 14, 15, 16, 17, 18 },
				{ 19, 20, 21, 22, 23, 24 }, 
				{ 25, 26, 27, 28, 29, 30 } 
				};

		int resultado = devuelvePosicion(matriz);

		System.out.println("El resultado es " + resultado );
	}

	// hay que multiplicar el numero de filas que haya anterior
	// al numero por el numero de elementos por fila MÁS el numero
	// de elementos en la fila anteriores al que queremos
	private static int devuelvePosicion(int[][] matriz) {
		// 3 es el NUMFILA y 5 es el NUMCOLUMNA
		int resultado = 3 * matriz[0].length + 5 + 1;

		return resultado;
	}

}
