package Tema3.boletin3;

public class Ejercicio9 {

	public static void main(String[] args) {

		for (int n = 0; n <= 10; n++) {

			System.out.printf("Tabla de multiplicar del %d\n", n);

			for (int a = 1; a <= 10; a++) {
				System.out.println(n + " * " + a + " = " + n * a);
			}
		}

	}
}
