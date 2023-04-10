package examenHerenciaEInterfaces;

public class JuguetePlastico extends Juguete {

	// Atributos
	public TipoPlastico tipoPlastico;

	// Constructor
	public JuguetePlastico(String nombre, String marca, TipoPlastico tipoPlastico) {
		super(nombre, marca);
		this.tipoPlastico = tipoPlastico;
	}

	public TipoPlastico getTipoPlastico() {
		return tipoPlastico;
	}

}
