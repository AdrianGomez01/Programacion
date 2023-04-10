package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineasAString {

	/**
	 * Para pasar todas las lineas del archivo a una sola linea, las vamos a meter
	 * en un SB, anhadienod tambien un espacio para mejor visivilidad y luego
	 * simplemente mostramos el SB por pantalla.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder textoSeguido = new StringBuilder();
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader("entrada1.txt"));
			String l;
			while ((l = inputStream.readLine()) != null) {
				textoSeguido.append(l).append(" ");
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				System.out.println(textoSeguido);
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
