package herenciaExamenAPasado;

import java.time.LocalDate;

public class FTextoFormateado extends FTexto implements Analizable{

	private String tipoFuente;
	private String colorFuente;
	private int tamanhoFuente;
	

	public FTextoFormateado(String nombre, LocalDate fechaCreacion, String[] parrafo, String tipoFuente,
			String colorFuente, int tamanhoFuente) throws FicheroException {
		super(nombre, fechaCreacion, parrafo);
		this.tipoFuente = tipoFuente;
		this.colorFuente = colorFuente;
		this.tamanhoFuente = tamanhoFuente;
	}

	public String getTipoFuente() {
		return tipoFuente;
	}

	public void setTipoFuente(String tipoFuente) {
		this.tipoFuente = tipoFuente;
	}

	public String getColorFuente() {
		return colorFuente;
	}

	public void setColorFuente(String colorFuente) {
		this.colorFuente = colorFuente;
	}

	public int getTamanhoFuente() {
		return tamanhoFuente;
	}

	public void setTamanhoFuente(int tamanhoFuente) {
		this.tamanhoFuente = tamanhoFuente;
	}

	@Override
	public void analizar() {
		System.out.printf("Analizando el fichero: " + getNombre() + "\n");
		
	}
	

}
