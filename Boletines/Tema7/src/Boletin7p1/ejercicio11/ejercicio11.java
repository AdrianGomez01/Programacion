package Boletin7p1.ejercicio11;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejercicio11 {

    private static final String RUTA_CARPETAS = "C:\\Users\\adrik\\Desktop\\Pogramacion\\Tema 7\\ficheros pt1\\ej11";

    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\adrik\\IdeaProjects\\Programacion\\Boletines\\Tema7\\src\\Boletin7p1\\ejercicio11\\alumnos.txt");
        Pattern expresion = Pattern.compile("((?:\\p{L}+\\\\s+)*\\p{L}+):((?:\\p{L}+\\\\s+)*\\p{L}+):((?:\\p{L}+\\\\s+)*\\p{L}+):(.+)$");

        try (
                BufferedReader br = new BufferedReader(new FileReader(archivo));
        ) {
            String l;
            while ((l = br.readLine()) != null) {
                Matcher m = expresion.matcher(l);
                if (m.find()) {
                    File ficheroCurso = new File(RUTA_CARPETAS + "\\" + m.group(4));
                    File ficheroAlumno = new File(RUTA_CARPETAS + "\\" + m.group(4) + "\\" + m.group(2) + m.group(3) + m.group(1));
                    if (!ficheroCurso.exists()) {
                        ficheroCurso.mkdir();
                    }
                    if (!ficheroAlumno.exists()) {
                        ficheroAlumno.mkdir();
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
