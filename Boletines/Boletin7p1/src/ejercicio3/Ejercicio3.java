package ejercicio3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Creamos todos los objetos dentro del ty w resources porque implementan
		// autocloseable, osea que se cerrarán automáticamente si estan aqui.
		try (BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter p = new PrintWriter(new FileWriter("salidaej3.txt"), true)) {
			String linea;
			while (!(linea = teclado.readLine()).equals("fin")) {
				linea = linea + System.lineSeparator();
				p.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
