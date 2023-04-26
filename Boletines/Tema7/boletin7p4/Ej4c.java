package Tema7.boletin7p4;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ej4c {

    private static final long MAX_TAMANO_ARCHIVO = 1000000; // tamaño máximo del archivo en bytes
    private static final String RUTA_ARCHIVO_LOG = "log.txt"; // ruta al archivo de log

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(RUTA_ARCHIVO_LOG, true);
            bw = new BufferedWriter(fw);

            while (true) {
                System.out.print("Introduce una línea para el log (o escribe 'salir' para finalizar): ");
                String linea = br.readLine();

                if ("salir".equalsIgnoreCase(linea)) {
                    break;
                }

                bw.write(linea);
                bw.newLine();

                if (new File(RUTA_ARCHIVO_LOG).length() > MAX_TAMANO_ARCHIVO) {
                    rotarLog();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo de log: " + e.getMessage());
            }
        }
    }

    private static void rotarLog() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String fechaHora = sdf.format(new Date());
        String nuevaRutaArchivoLog = "log_" + fechaHora + ".txt";
        File archivoLog = new File(RUTA_ARCHIVO_LOG);
        File nuevoArchivoLog = new File(nuevaRutaArchivoLog);
        boolean renombrado = archivoLog.renameTo(nuevoArchivoLog);
        if (!renombrado) {
            throw new IOException("Error al renombrar el archivo de log.");
        }
    }
}
