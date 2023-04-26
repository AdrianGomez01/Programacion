package Tema7.boletin7p4;

import java.io.*;
import java.util.regex.Pattern;

public class Ej2 {
    public static void main(String[] args) {
        File f = new File("Boletines/Tema7/boletin7p4/ejercicio2.txt");
        int contador = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            Pattern plantilla = Pattern.compile("Limones", Pattern.CASE_INSENSITIVE);
            String l;
            while ((l = br.readLine()) != null) {
                contador += plantilla.matcher(l).results().count();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("En el archivo hay " + contador + " limones");
    }
}
