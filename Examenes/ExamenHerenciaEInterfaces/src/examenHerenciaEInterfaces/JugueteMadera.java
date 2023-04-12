package ExamenHerenciaEInterfaces.src.examenHerenciaEInterfaces;

public class JugueteMadera extends Juguete {

	// Atributos
	private String origenMadera;
	private int anhoTala;

	// Constructor
	public JugueteMadera(String nombre, String marca, String origenMadera, int anhoTala) {
		super(nombre, marca);
		this.origenMadera = origenMadera;
		this.anhoTala = anhoTala;
	}

	public String getOrigenMadera() {
		return origenMadera;
	}

	public int getAnhoTala() {
		return anhoTala;
	}

}
