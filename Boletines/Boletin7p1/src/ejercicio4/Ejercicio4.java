package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ejercicio4 {

	public static void main(String[] args) {
		try (BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
			String linea;
			Path path = Paths.get("salidaej3.txt");
			while (!(linea = teclado.readLine()).equals("fin")) {
				linea = linea + System.lineSeparator();
				Files.write(path, linea.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
