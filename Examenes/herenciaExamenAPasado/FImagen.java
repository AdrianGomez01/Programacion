package herenciaExamenAPasado;

import java.time.LocalDate;

public class FImagen  extends FBinario{

	private String formato;


	public FImagen(String nombre, LocalDate fecha_creacion, Byte[] arrayBytes, String formato) throws FicheroException {
		super(nombre, fecha_creacion, arrayBytes);
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	

}
