package ExamenHerenciaEInterfaces.src.examenHerenciaEInterfaces;

public class FiguraMadera extends JugueteMadera implements IApilable {

	// Atributos
	private String color;
	private int numLados;

	// Constructor
	public FiguraMadera(String nombre, String marca, String origenMadera, int anhoTala, String color, int numLados) {
		super(nombre, marca, origenMadera, anhoTala);
		this.color = color;
		this.numLados = numLados;
	}

	public String getColor() {
		return color;
	}

	public int getNumLados() {
		return numLados;
	}

	@Override
	public String toString() {
		return "FiguraMadera [color=" + color + ", numLados=" + numLados + ", OrigenMadera=" + getOrigenMadera()
				+ ", AnhoTala=" + getAnhoTala() + ", Nombre=" + getNombre() + ",Marca=" + getMarca() + "]";
	}

	@Override
	public void apilar() {
		// TODO Auto-generated method stub

	}

}
