package Tema7.boletin7p4;

import java.io.*;

public class Ej8c {
    private static final String BITACORA_FILE = "bitacora.txt";
    private static final int MIN_LONGITUD_LINEA = 10;
    private static final String[] PALABRAS_CLAVE = {"error", "problema", "falla"};

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(BITACORA_FILE, true));
            // Si el archivo ya existe, se abre en modo de "append" para añadir al final del archivo
            // Si el archivo no existe, se crea automáticamente

            System.out.println("Escribe una línea para añadir a la bitácora (o escribe 'salir' para terminar):");

            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("salir")) {
                    break;
                }

                if (line.length() < MIN_LONGITUD_LINEA) {
                    System.out.println("¡La línea debe tener al menos " + MIN_LONGITUD_LINEA + " caracteres!");
                    continue;
                }

                boolean contienePalabraClave = false;

                for (String palabra : PALABRAS_CLAVE) {
                    if (line.contains(palabra)) {
                        contienePalabraClave = true;
                        break;
                    }
                }

                if (!contienePalabraClave) {
                    System.out.println("¡La línea debe contener al menos una de las siguientes palabras clave: " + String.join(", ", PALABRAS_CLAVE) + "!");
                    continue;
                }

                // Escribir la línea en el archivo
                writer.write(line);
                writer.newLine();

                System.out.println("Escribe otra línea para añadir a la bitácora (o escribe 'salir' para terminar):");
            }

            writer.close();

            System.out.println("¡Se han añadido las líneas a la bitácora!");
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al escribir en la bitácora");
            e.printStackTrace();
        }
    }
}
