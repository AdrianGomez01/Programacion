package herenciaExamenAPasado;

import java.time.LocalDate;

public abstract class FTexto extends Fichero implements Convertible{

	public String[] parrafo;
	
	public FTexto(String nombre, LocalDate fechaCreacion,String[] parrafo) throws FicheroException {
		super(nombre, calcularTamanho(parrafo), fechaCreacion);
		this.parrafo = parrafo;
	}

	private static long calcularTamanho(String[] parrafo) {
		long acum = 0;
		for (String c : parrafo) {
			acum += c.length();
		}
		return acum;
		
		//Esto sería lo mismo pero usando flujos, que aun no los hemos visto.
		// return Arrays.stream(texto).reduce(String::concat).get().lenght();
	}

	@Override
	public String convertir() {
		StringBuilder acum = new StringBuilder();
		for (String s : parrafo) {
			acum.append(s);
		}
		return acum.toString();
	}
	
	
}
