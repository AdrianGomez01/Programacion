package herenciaExamenAPasado;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws FicheroException {

		LocalDate fecha = LocalDate.now();
		
		Fichero[] ficheros = {
				new FTextoPlano("FTP1.txt", fecha, new String []{"Hola","cozas","mereketengue"}),
				new FTextoPlano("FTP2.txt", fecha, new String []{"Hola","cozitas","mamelungas"}),
				new FTextoFormateado("FTF1.txt", fecha, new String []{"Hola","bakugans","pikipiki"}, "Arial", "Rojo",20 ),
				new FVideo("FV1.mp4", fecha, new Byte []{7,1,2}, 30),
				new FAudio("FA1.mp3", fecha, new Byte []{0,4,2}, 30),
				new FImagen("FI1.png", fecha, new Byte []{2,4,2}, "png"),
				new FEjecutable("FE1.exe", fecha, new Byte []{6,1,2}, 30),
		};
		
		
		for (Fichero f : ficheros) {
			if (f instanceof Analizable) {
				//Esto convierte en analizable el fichero, y luego se le ejecuta analizar
				((Analizable) f).analizar();
			}
			if (f instanceof Convertible) {
				//Le ponemos un syso porque devuelve un string
				System.out.println(((Convertible) f).convertir());;
			}
			if (f instanceof Reproducible) {
				((Reproducible) f).reproducir();
			}
			if (f instanceof Representable) {
				((Representable) f).representar();
			}
		}
		
		
		/**

		System.out.println(menu());
		int opcion = MiEntradaSalida.leerEnteroEnRango("Escriba una opcion", 1, 5);
		switch (opcion) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		}
		 */
	}

	public static String menu() {
		StringBuilder string = new StringBuilder();
		string.append("Elige una opción: ").append("\n");
		string.append("1.  ").append("\n");
		string.append("2.  ").append("\n");
		string.append("3.  ").append("\n");
		string.append("4.  ").append("\n");
		string.append("5.  ").append("\n");
		return string.toString();
	}

}
