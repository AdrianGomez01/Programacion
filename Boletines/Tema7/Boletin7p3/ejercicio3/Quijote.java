package Tema7.Boletin7p3.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quijote {

    public static void main(String[] args) {

        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt"));) {

            String linea;
            Pattern patron = Pattern.compile("([Rr]az[óo]n)");

            while ((linea = reader.readLine()) != null) {
                Matcher m = patron.matcher(linea);
                contador +=m.results().count();
                m.results().forEach(r -> System.out.println(r.start() + " " + r.group()));
                //contador +=m.results().filter(x -> x.group().contains("ó")).count();
            }

            System.out.println("Razones encontradas = " + contador);

            System.out.println("*********************");

            contador = 0;
            patron = Pattern.compile("([áéíóúÁÉÍÓÚñÑ])");
            while ((linea = reader.readLine()) != null) {
                Matcher m = patron.matcher(linea);
                contador += m.results().count();
                //m.results().forEach(r -> System.out.println(r.start() + " " + r.group()));
                contador += m.results().filter(x -> x.group().contains("ó")).count();
            }

            System.out.println("Vocales encontradas = " + contador);


        } catch (IOException e) {
            System.err.println("No se ha podido encontrar el archivo: " + e);
        }
    }
}