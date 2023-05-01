package Tema7.boletin7p4;

import java.io.*;

public class Ej7c {
    private static final String REGISTRO_FILE = "registro.txt";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(REGISTRO_FILE, true));
            // Si el archivo ya existe, se abre en modo de "append" para añadir al final del archivo
            // Si el archivo no existe, se crea automáticamente

            System.out.println("Escribe una línea para añadir al registro (o escribe 'salir' para terminar):");

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    System.out.println("¡No se permiten líneas vacías!");
                    continue;
                }

                if (line.equalsIgnoreCase("salir")) {
                    break;
                }

                // Escribir la línea en el archivo
                writer.write(line);
                writer.newLine();

                System.out.println("Escribe otra línea para añadir al registro (o escribe 'salir' para terminar):");
            }

            writer.close();

            System.out.println("¡Se han añadido las líneas al registro!");
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al escribir en el registro");
            e.printStackTrace();
        }
    }
}
