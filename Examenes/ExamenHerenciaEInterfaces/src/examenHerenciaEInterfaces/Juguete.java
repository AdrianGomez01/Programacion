package examenHerenciaEInterfaces;

public abstract class Juguete {

	// Atributos
	private String nombre;
	private String marca;

	// Constructor
	public Juguete(String nombre, String marca) {
		super();
		this.nombre = nombre;
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

}
