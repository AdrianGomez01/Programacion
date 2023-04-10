package Tema3.t3Boletin1;

public class ej14 {

	private static int tamCola = 0;
	private static int[] cola = new int[10];
	private static int primerElemento = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			encolar(i);
		}
		
		for (int i = 0; i < 4; i++) {
			desEncolar();
		}
		for (int i = 55; i < 59; i++) {
			encolar(i);
		}
	}

	private static void encolar(int numero) {
		if (tamCola < 10) {
			cola[(primerElemento + tamCola) % cola.length] = numero; // el tamaño de la cola en este caso es 10
		}
	}

	private static void desEncolar() {
		if (tamCola > 0) {
			cola[primerElemento] = 0; // Visualmente cambia el elmento a 0 aunque estaba bien sin esta linea
			primerElemento = (primerElemento + 1) % cola.length;
			tamCola--;
		}
	}
}