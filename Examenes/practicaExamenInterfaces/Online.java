package practicaExamenInterfaces;

public class Online extends Pagos implements Pago {

	public Online(double cantidad) {
		super(cantidad, TipoPago.ONLINE);

	}


}
