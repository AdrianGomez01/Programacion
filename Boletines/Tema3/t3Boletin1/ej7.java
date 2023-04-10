package Tema3.t3Boletin1;

public class ej7 {

	public static void main(String[] args) {
		int[] miArray = { 1, 2, 3, 4, 5 }; //definimos el array

		//contieneElemento se va a sustituir por lo que devuelva la funcion
		//en este caso true o false.
		//El 1 es el valor que está buscando.
		if (contieneElemento(miArray, 1)) {
			System.out.println("Si, lo contiene");
		} else {
			System.out.println("No, no lo contiene");
		}

	}
	
	//Creamos el método
	private static boolean contieneElemento(int[] array, int elemento) {
		//recorremos el array con el for
		for (int i = 0; i < array.length; i++) {
			if (array[i] == elemento) {
				return true;
			}
		}
		return false; // en vez de poner 2 returns lo suyo es poner una variable
						// que cambie de true a false y el return devuelva esa variable
	}

}
