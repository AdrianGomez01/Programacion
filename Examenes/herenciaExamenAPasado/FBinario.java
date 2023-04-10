package herenciaExamenAPasado;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class FBinario extends Fichero{

	private Byte[] arrayBytes;
	
	public FBinario(String nombre, LocalDate fecha_creacion,Byte[] arrayBytes) throws FicheroException {
		super(nombre,arrayBytes.length ,fecha_creacion);
		this.arrayBytes = arrayBytes;
		
	}

	@Override
	public String toString() {
		return "FBinario [arrayBytes=" + Arrays.toString(arrayBytes) + "]";
	}

}
