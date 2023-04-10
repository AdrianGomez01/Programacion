package Tema3.t3Boletin1;

public class ej12 {

	public static void main(String[] args) {

		int[] miArray = { 1, 5, 3, 2, 4 }; //definimos el array
		int[] arrayAux; // Este array nos servirá para hacer el intercambio
		
		for (int i = 0; i < miArray.length -1; i++) {
			for (int j = 0; j < miArray.length - i - 2; j++) {
				if (miArray[i]>miArray[i++]) {
					arrayAux = miArray;
					miArray[i] =miArray[i++];
					miArray = arrayAux;
				}
			}
		}
	}

}
