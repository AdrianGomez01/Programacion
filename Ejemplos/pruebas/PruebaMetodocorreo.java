package pruebas;

import java.util.Scanner;

public class PruebaMetodocorreo {

	
	private static final Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Introduzca su direccion de correo");
		String correo = teclado.nextLine();
		getDominio(correo);
	}
	
	public static void getDominio(String correo) {
		int posArroba = correo.indexOf("@");
		int posPunto = correo.indexOf(".");
		String Dominio = correo.substring(posArroba+1 , posPunto);
		System.out.println(Dominio);
	}
	
}