package Tema7.boletin7p4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej3 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File archivo = new File("Boletines/Tema7/boletin7p4/ejercicio.txt");

        System.out.println("Introduzca la palabra que desa buscar");
        String palabra = sc.next(); // especifica la palabra que se desea buscar
        sc.close();

       //no va hulio
       // BufferedReader palabra = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
