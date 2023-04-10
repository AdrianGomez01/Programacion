package herenciaExamenAPasado;

import java.time.LocalDate;

public class FAudio extends FBinario implements Reproducible{

	private int duracion;


	public FAudio(String nombre, LocalDate fecha_creacion, Byte[] arrayBytes, int duracion) throws FicheroException {
		super(nombre, fecha_creacion, arrayBytes);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public void reproducir() {
		System.out.println("Reproduciendo el audio: " + getNombre());
	}
	
	

}
