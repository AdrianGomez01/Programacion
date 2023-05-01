package Tema7.boletin7p4;

import java.io.*;
import java.util.*;

public class Ej9c {
    private static final String FILE_NAME = "notas.txt";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        List<String> notas = new ArrayList<String>();

        try {
            // Leer el archivo completo
            BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME));
            while ((line = fileReader.readLine()) != null) {
                notas.add(line);
            }
            fileReader.close();

            // Ordenar las notas alfabéticamente
            Collections.sort(notas);

            // Añadir la nueva nota en la posición correcta para mantener el orden
            System.out.println("Escribe una nueva nota:");
            line = reader.readLine();
            int index = Collections.binarySearch(notas, line);
            if (index < 0) {
                index = -index - 1;
            }
            notas.add(index, line);

            // Escribir las notas ordenadas en el archivo
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME));
            for (String nota : notas) {
                fileWriter.write(nota);
                fileWriter.newLine();
            }
            fileWriter.close();

            System.out.println("La nota se ha añadido correctamente.");
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}

