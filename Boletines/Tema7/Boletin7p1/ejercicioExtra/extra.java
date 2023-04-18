package Tema7.Boletin7p1.ejercicioExtra;

import java.io.*;
import java.util.regex.Pattern;

public class extra {

    public static void main(String[] args) {

        File entrada = new File("C:\\Users\\adrik\\IdeaProjects\\Programacion\\Boletines\\Tema7\\src\\Boletin7p1\\ejercicioExtra\\entrada.txt");
        File salida = new File("C:\\Users\\adrik\\IdeaProjects\\Programacion\\Boletines\\Tema7\\src\\Boletin7p1\\ejercicioExtra\\salida.txt");
        //Pattern patron = Pattern.compile("\\p{L}}");

        try (
                BufferedReader br = new BufferedReader(new FileReader(entrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(salida))
        ) {
            String l;
            while ((l = br.readLine()) != null){
                    bw.write(l.toUpperCase().charAt(0) + l.substring(1).toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
