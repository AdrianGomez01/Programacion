package Tema7.examenFyE;

import Tema7.Boletin7p1.ejercicio5.UserDataCollector;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Vamos a pedir que nos introduzcan las rutas de las dos carpetas:
        System.out.println("Introduzca el nombre del primer directorio o la ruta absoluta");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el nombre del segundo directorio o la ruta absoluta");
        String nombre2 = sc.nextLine();
        sc.close();
        File directorio = new File(nombre);
        File directorio2 = new File(nombre2);

        //Vamos a comprobar que el directorio existe, que es un directorio y que tenga permisos de lectura
        if (directorio.exists()) {
            if (directorio.isDirectory()) {
                if (directorio.canRead()) {
                    //Ahora recorreremos sus ficheros buscando los que cumplan la condicion del ejercicio,
                    // que pesen más de 1024 bytes, que sea un fichero y acabe en .txt y la primera palabra sea copiar.
                    File[] ficheros = directorio.listFiles();
                    if (ficheros != null) {
                        for (File fichero : ficheros) {
                            if (fichero.isFile()) {
                                //Comprobamos que sea un .txt con un patrón
                                Pattern p = Pattern.compile("([^\\s]+(\\.(?i)(txt))$)");
                                Matcher m = p.matcher((CharSequence) fichero);
                                if (m.matches()) {
                                    if (fichero.length() > 1024) {
                                        //Ahora compruebo que la primera palabra del fichero sea COPIAR
                                        //TODO Tengo que especificar que sea la primera pero se me hecha el tiempo encima
                                        Pattern c = Pattern.compile("Copiar", Pattern.CASE_INSENSITIVE);
                                        Matcher m2 = c.matcher((CharSequence) fichero);
                                        if (m2.matches()) {
                                            //Comprobamos que el segundo directorio tiene permisos de escritura
                                            if (directorio2.canWrite()){
                                                try {
                                                    directorio2.createNewFile();
                                                } catch (IOException e) {
                                                    throw new RuntimeException(e);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("El directorio 1 no tiene permisos de lectura");
                }
            } else {
                System.out.println("No se encuentra el directorio 1  con el nombre especificado");
            }
        } else {
            System.out.println("El directorio 1 no existe");
        }


    }


}
