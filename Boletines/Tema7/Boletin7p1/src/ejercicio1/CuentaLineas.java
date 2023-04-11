package Tema7.Boletin7p1.src.ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuentaLineas {

	/**
	 * Para hacer que cuente las lineas del archivo anhado un contador al cual vamos
	 * sumando 1 por cad línea que lee de su imput.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		BufferedReader inputStream = null;
		int numLineas = 0;
		try {
			inputStream = new BufferedReader(new FileReader("entrada1.txt"));
			String l;
			while ((l = inputStream.readLine()) != null) {
				numLineas++;
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				System.out.println("El archivo tiene " + numLineas + " lineas.");
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
