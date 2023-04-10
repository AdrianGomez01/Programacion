package ficherosDeTexto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MostrarFicheroTextoPorLineas {

	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
	
		String nombreFichero;
		System.out.println("Introduce el nombre del fichero:");
		nombreFichero=teclado.nextLine();
		
		mostrarFicheroDeTexto(nombreFichero);
		
		
	}
	
	private static void mostrarFicheroDeTexto(String nombreFichero) {
		String linea;
		int numeroDelineas=0;
		try
		{
			FileReader flujoLectura=new FileReader(nombreFichero);
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			
			linea=filtroLectura.readLine();
			while ( linea!=null){
				numeroDelineas++;
				
				linea=filtroLectura.readLine();
				
			}
			
			System.out.println("Fin");
			System.out.println("Numero de lineas " + numeroDelineas);
			filtroLectura.close();
			flujoLectura.close();
		}
		catch(FileNotFoundException e){
			System.out.println("No existe el fichero " + nombreFichero);
		}
		catch(IOException e){
			System.out.println( e.getMessage());
		}
		
	}
	
	

}
