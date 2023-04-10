package examenHerenciaEInterfaces;

public class VehiculoPlastico extends JuguetePlastico {

	// Atributos
	private int numRuedas;

	// Constructor
	public VehiculoPlastico(String nombre, String marca, int numRuedas) {
		super(nombre, marca, TipoPlastico.PVC);
		this.numRuedas = numRuedas;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	@Override
	public String toString() {
		return "VehiculoPlastico [numRuedas=" + numRuedas + ", TipoPlastico=" + getTipoPlastico() + ", Nombre="
				+ getNombre() + ", Marca=" + getMarca() + "]";
	}

}
