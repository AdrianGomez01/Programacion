package herenciaExamenAPasado;

import java.time.LocalDate;

public class FEjecutable  extends FBinario implements Analizable{

	private int permisos;


	public FEjecutable(String nombre, LocalDate fecha_creacion, Byte[] arrayBytes, int permisos)
			throws FicheroException {
		super(nombre, fecha_creacion, arrayBytes);
		this.permisos = permisos;
	}



	@Override
	public void analizar() {
		System.out.printf("Analizando el fichero: " + getNombre());
		
	}
	
	

}
