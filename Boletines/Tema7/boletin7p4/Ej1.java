package Tema7.boletin7p4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej1 {
    public static void main(String[] args) {
        File fichero = new File("Boletines/Tema7/boletin7p4/ejercicio.txt");
        Pattern p = Pattern.compile("\\p{L}+");
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Matcher m = p.matcher(linea);
                while (m.find()) {
                    contador++;
                }
            }
            System.out.println("El fichero tiene " + contador + " palabras");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
