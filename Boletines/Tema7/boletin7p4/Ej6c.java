package Tema7.boletin7p4;

import java.io.*;

public class Ej6c {
    private static final String BITACORA_FILE = "bitacora.txt";
    private static final int MAX_FILE_SIZE = 1024 * 1024; // 1MB

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

                // Verificar si el archivo supera el tamaño máximo permitido
                File bitacoraFile = new File(BITACORA_FILE);
                if (bitacoraFile.exists() && bitacoraFile.length() > MAX_FILE_SIZE) {
                    // Si el archivo es demasiado grande, borrar la primera línea
                    RandomAccessFile raf = new RandomAccessFile(BITACORA_FILE, "rw");
                    raf.readLine(); // leer la primera línea y descartarla
                    long writePos = raf.getFilePointer();
                    String remainingLines = null;

                    while ((remainingLines = raf.readLine()) != null) {
                        raf.seek(writePos);
                        raf.writeBytes(remainingLines);
                        writePos = raf.getFilePointer();
                    }

                    raf.setLength(writePos);
                    raf.close();
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
