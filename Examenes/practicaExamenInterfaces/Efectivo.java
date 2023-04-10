package practicaExamenInterfaces;

public class Efectivo extends Pagos implements Pago{

	public Efectivo(double cantidad) {
		super(cantidad, TipoPago.EFECTIVO);
	}
	

}
