package Tema7.Boletin7p1.ejercicio8;

import java.io.File;
import java.util.Scanner;

public class Ejercicio8 {
    private static final String PATRON = "^(\\p{L}{2,})\\s([a-zA-Z]{2,})\\s(\\p{L}{2,})\\s(0?[1-9]|[1-9][0-9])$";
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        String nombreFichero;

        System.out.println("Introduce el nombre del fichero de texto: ");
        nombreFichero = teclado.nextLine();
        String fichero = buscarArchivoEnDirectorio(nombreFichero);

        if (fichero != null && fichero.matches(PATRON)) {
            System.out.println("Sus datos son:");
            System.out.println(fichero);
        } else {
            System.out.println("ERROR, El resultado es nulo o no encaja");
        }

    }

    private static String buscarArchivoEnDirectorio(String nombreFile) {
        System.out.println("Introduzca el nombre del directorio o la ruta absoluta donde se encuentra el fichero");
        String nombreDir = teclado.nextLine();
        File directorio = new File(nombreDir);
        if (directorio.exists()) {
            if (directorio.isDirectory()) {
                if (directorio.canRead()) {
                    File[] ficheros = directorio.listFiles();
                    if (ficheros != null) {
                        for (File fichero : ficheros) {
                            if (fichero.getName().equalsIgnoreCase(nombreFile)) {
                                if (fichero.isFile()) {
                                    return fichero.toString();
                                } else {
                                    System.out.println(fichero.getName() + "es un directorio o acceso directo");
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("El directorio no tiene permisos de lectura");
                }
            } else {
                System.out.println("No se encuentra el directorio con el nombre especificado");
            }
        } else {
            System.out.println("El directorio no existe");
        }
        return null;
    }
}
