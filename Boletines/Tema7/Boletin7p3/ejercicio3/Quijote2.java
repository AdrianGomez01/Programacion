package Tema7.Boletin7p3.ejercicio3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quijote2 {
    public static void main(String[] args) throws IOException {

        int contador = 0;
        Pattern patron = Pattern.compile("([Rr][Aa][Zz][ÓóOo][Nn])");
        File fichero = new File("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt");


        try (BufferedReader reader = new BufferedReader(new FileReader("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt"));) {

            String linea;

            while ((linea = reader.readLine()) != null) {
                Matcher m = patron.matcher(linea);
                while (m.find()) {
                    contador++;
                }
            }
            System.out.println("La palabra razón se encuentra: " + contador + " veces");

        } catch (IOException e) {
            System.err.println("No se ha podido encontrar el archivo: " + e);
        }


        System.out.println("Se han encontrado " + contarTildes() + " tildes.");
        System.out.println("En el documento hay un total de " + cuentaPalabras() + " palabras.");

        quincePalabras(15);

    }

    private static int contarTildes() throws FileNotFoundException, IOException {
        int contadorTildes = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt"));) {

            String linea;
            Pattern patron = Pattern.compile("[áéíóúÁÉÍÓÚ\u00f1\u00d1]");

            while ((linea = lector.readLine()) != null) {
                Matcher m = patron.matcher(linea);
                contadorTildes += m.results().count();
            }

        } catch (IOException e) {
            System.err.println("No se ha podido encontrar el archivo: " + e);
        }

        return contadorTildes;
    }

    private static void eliminarNumerosTrasPalabras() {
        Pattern numeros = Pattern.compile("(\\p{L}+)([0-9]+)");
        File fichero = new File("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt");
        File nuevoFichero = new File("Boletines/Tema7/Boletin7p3/ejercicio3/QuijoteNuevo.txt");

        try (BufferedReader lector = new BufferedReader(new FileReader(fichero));
             PrintWriter pw = new PrintWriter(new FileWriter(nuevoFichero))) {

            String l;
            while ((l = lector.readLine()) != null) {
                pw.println(l.replaceAll("(\\p{L}+)([0-9]+)", "$1"));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void capitalizar() throws IOException {
        File fichero = new File("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt");


    }

    private static void quincePalabras(int i) {
        try (BufferedReader lector = new BufferedReader(new FileReader("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt"))) {
            String linea;

            Pattern p = Pattern.compile("([^\\.]+)");
            Pattern p2 = Pattern.compile("([^\\p{Z}]+)");

            while ((linea = lector.readLine()) != null) {
                Matcher m = p.matcher(linea);
                while (m.find()) {
                    String frase = m.group();
                    Matcher m2 = p2.matcher(frase);
                    if (m2.results().count() < i) {
                        System.out.println(frase);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int cuentaPalabras() {
        int contadorPalabras = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader("Boletines/Tema7/Boletin7p3/ejercicio3/quijote.txt"))) {
            String linea;
            Pattern p = Pattern.compile("\\p{L}+");

            while ((linea = lector.readLine()) != null) {
                contadorPalabras += p.matcher(linea).results().count();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contadorPalabras;
    }


}

