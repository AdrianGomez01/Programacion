package herenciaExamenAPasado;

import java.time.LocalDate;

public class FTextoPlano extends FTexto implements Representable{

	public FTextoPlano(String nombre, LocalDate fechaCreacion, String[] parrafo) throws FicheroException {
		super(nombre, fechaCreacion, parrafo);
		
	}

	@Override
	public void representar() {
		for (int i = 0; i < parrafo.length; i++) {
			System.out.println(parrafo[i]);
		}
		
	}

	

}
