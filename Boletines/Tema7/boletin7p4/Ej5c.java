package Tema7.boletin7p4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Ej5c {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("datos.txt", true));
            // Si el archivo ya existe, se abre en modo de "append" para añadir al final del archivo
            // Si el archivo no existe, se crea automáticamente

            System.out.println("Escribe una línea para añadir al archivo (o escribe 'salir' para terminar):");

            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("salir")) {
                    break;
                }

                writer.write(line);
                writer.newLine();

                System.out.println("Escribe otra línea (o escribe 'salir' para terminar):");
            }

            writer.close();

            System.out.println("¡Se han añadido las líneas al archivo 'datos.txt'!");
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al escribir en el archivo 'datos.txt'");
            e.printStackTrace();
        }
    }
}

