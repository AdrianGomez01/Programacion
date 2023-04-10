package boletin5p1;

public class Vehiculos {
	
	private String matricula;
	private String gama;
	private String tipoVehiculo;
	private int numPlazas;
	private int tipoMotor;
	private int pma;
	
	/**
	 * Constructor de Vehiculo
	 * @param matricula
	 * @param gama
	 * @param tipoVehiculo
	 */
	public Vehiculos(String matricula, String gama, String tipoVehiculo) {
		super();
		this.matricula = matricula;
		this.gama = gama;
		this.tipoVehiculo = tipoVehiculo;
		
	}

	/**
	 * Tipo de vehiculo Coche
	 */
	public void Coche() {
		this.tipoVehiculo = getTipoVehiculo();
		this.tipoMotor = getTipoMotor();
	
	}

	/**
	 * Tipo de vehiculo Microbus
	 */
	public void Microbus() {
		this.tipoVehiculo = getTipoVehiculo();
		this.numPlazas = getNumPlazas();
	
	}
	
	/**
	 * Tipo de vehiculo Furgoneta
	 */
	public void Furgoneta() {
		this.tipoVehiculo = getTipoVehiculo();
		this.pma = getPma();
	
	}

	
	public String getMatricula() {
		return matricula;
	}

	public String getGama() {
		return gama;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public int getTipoMotor() {
		return tipoMotor;
	}

	public int getPma() {
		return pma;
	}
	
	
	
}
