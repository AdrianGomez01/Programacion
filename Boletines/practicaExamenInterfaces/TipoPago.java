package practicaExamenInterfaces;

public enum TipoPago {

	EFECTIVO(0.0), TARJETA(5.0), ONLINE(3.0);

	private double incremento;

	private TipoPago(double incremento) {
		this.incremento = incremento;
	}

	public double getIncremento() {
		return incremento;
	}

}
