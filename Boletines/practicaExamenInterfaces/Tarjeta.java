package practicaExamenInterfaces;

public class Tarjeta extends Pagos implements Pago {

	public Tarjeta(double cantidad) {
		super(cantidad, TipoPago.TARJETA);
	
	}

}
