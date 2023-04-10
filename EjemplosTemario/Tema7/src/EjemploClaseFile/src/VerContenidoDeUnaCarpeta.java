import java.io.File;
import java.util.Scanner;

public class VerContenidoDeUnaCarpeta {

	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		String nombreCarpetaACrear;
		File directorio;
		boolean creada;
		String[] contenido;
		File[] contenidoFiles;
		
		System.out.println("Introduce el nombre de la carpeta que quieres ver:");
		nombreCarpetaACrear= teclado.nextLine();
		
		directorio=new File(nombreCarpetaACrear);
		
		
		if ( !directorio.isDirectory()) {
			System.out.println("No es una carpeta");
		}
		else {
			contenido=directorio.list();
			for (int i = 0; i < contenido.length; i++) {
				System.out.println(contenido[i]);
			}
			
			contenidoFiles=directorio.listFiles();
			for (int i = 0; i < contenidoFiles.length; i++) {
				if ( contenidoFiles[i].isFile()) {
					System.out.println(contenidoFiles[i] + " es un fichero y tiene " + contenidoFiles[i].length() + " bytes");
				}
				else {
					System.out.println(contenidoFiles[i] + " es un directorio");
				};
			}
			
		}
	

	}

}
