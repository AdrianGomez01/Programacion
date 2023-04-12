package ExamenColecciones2022.src;

public abstract class Cromo {
	private int id;
	private String nombre;

	public Cromo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	/**
	 * Tan solo tenemos en cuenta el id para comparar
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cromo)) {
			return false;
		}
		Cromo other = (Cromo) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
	
}
