package Tema7.Boletin7p1.ejercicio6;

import java.io.File;
import java.io.IOException;

import Tema7.Boletin7p1.ejercicio5.UserDataCollector;

public class Ejercicio6 {

	public static void main(String[] args) {

		try {
			mostrarTamanhoFicherosDeCarpeta();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarTamanhoFicherosDeCarpeta() throws IOException {
		String directorio = UserDataCollector.getString("Introduce la ruta absoluta al directorio");

		File dir = new File(directorio);

		if (!dir.exists() || !dir.isDirectory()) {
			throw new IOException("La ruta introducida no es un directorio válido");
		}

		try {
			for (File file : dir.listFiles()) {
				String salida = "";
				if (file.isDirectory()) {
					salida += "D - ";
				} else {
					salida += "F - ";
					salida += ((double) file.length() / 1024 + " KB - ");
				}
				System.out.println(salida + file.getName());
			}

		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}

	}
}
