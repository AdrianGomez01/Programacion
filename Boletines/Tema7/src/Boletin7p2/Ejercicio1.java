package Boletin7p2;

import java.util.Scanner;

public class Ejercicio1 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("1. Crear directorio");
            System.out.println("2. Crear fichero de texto");
            System.out.println("3. Borrar fichero de texto");
            System.out.println("4. Mostrar los ficheros que contiene una carpeta");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> crearDirectorio();
                case 2 -> crearFicheroTexto();
                case 3 -> borrarFicheroTexto();
                case 4 -> listarFicherosCarpeta();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
        sc.close();
    }

    private static void crearDirectorio() {
    }

    private static void crearFicheroTexto() {
    }

    private static void borrarFicheroTexto() {
    }

    private static void listarFicherosCarpeta() {
    }
}
