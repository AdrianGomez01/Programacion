package examenHerenciaEInterfaces;

public class InstrumentoMusical extends JugueteMadera {

	// Atributos
	private int edadMin;

	public InstrumentoMusical(String nombre, String marca, String origenMadera, int anhoTala, int edadMin) {
		super(nombre, marca, origenMadera, anhoTala);
		this.edadMin = edadMin;
	}

	public int getEdadMin() {
		return edadMin;
	}

	@Override
	public String toString() {
		return "InstrumentoMusical [edadMin=" + edadMin + ", OrigenMadera=" + getOrigenMadera() + ", AnhoTala="
				+ getAnhoTala() + ", Nombre=" + getNombre() + ", Marca=" + getMarca() + "]";
	}

}
