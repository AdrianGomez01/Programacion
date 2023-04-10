package Tema4.Boletin4p4;

import java.util.Scanner;

public class Ej10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String direccion = sc.nextLine();
		sc.close();
		
		System.out.println(validarDireccion(direccion));
	}

	public static boolean validarDireccion(String direccion) {
		boolean validacion = true;
		String[] separacion1 = direccion.split("://");

		if (separacion1.length != 2) {
			validacion = false;
		}

		if (validacion) {
			//Ponemos "\\" delante del punto porque tiene que ser una expresion regular, si no no lo va a aceptar.
			String[] separacion2 = separacion1[1].split("\\.");

			if (separacion2.length != 3) {
				validacion = false;
			}

			if (validacion && !Character.isLetter(separacion2[1].charAt(0))) {
				validacion = false;
			}
			
		}

		return validacion;
	}
}
