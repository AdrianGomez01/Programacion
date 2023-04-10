package examenHerenciaEInterfaces;

public class PiezaLego extends JuguetePlastico implements IApilable {

	// Atributos
	private int longitud;
	private String color;

	// Constructor
	public PiezaLego(String nombre, String marca, int longitud, String color) {
		super(nombre, marca, TipoPlastico.ABS);
		this.longitud = longitud;
		this.color = color;
	}

	public int getLongitud() {
		return longitud;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "PiezaLego [longitud=" + longitud + ", color=" + color + ", TipoPlastico=" + getTipoPlastico()
				+ ", Nombre=" + getNombre() + ", Marca=" + getMarca() + "]";
	}

	@Override
	public void apilar() {
		// TODO Auto-generated method stub

	}

}
