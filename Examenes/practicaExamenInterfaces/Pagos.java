package practicaExamenInterfaces;

public abstract class Pagos implements Pago {

	private double cantidad;
	private TipoPago tipo;
	
	public Pagos(double cantidad, TipoPago tipo) {
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	@Override
	public double calcularImporte() {
		return this.cantidad * 1 +(tipo.getIncremento() / 100);
	}

	@Override
	public TipoPago getTipoPago() {
		return tipo;
	}
	
	@Override
	public double calcularIncremento() {
		return this.cantidad * tipo.getIncremento() / 100;
	}

}
