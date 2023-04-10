package practicaExamenInterfaces;

public class ListaPagos {

	private Pago[] pago;

	public ListaPagos(Pago[] pago) {
		super();
		this.pago = pago;
	}

	public static void main(String[] args) {
		Pago[] pago = new Pago[] { new Efectivo(34.6), new Efectivo(56.4), new Tarjeta(23), new Online(67.34) };

		ListaPagos uno = new ListaPagos(pago);
		System.out.println(uno.calcularTotal());
		System.out.println(uno.contarTipoPago(TipoPago.EFECTIVO));
		System.out.println(uno.calcularTotalIncremento());

	}

	public double calcularTotal() {

		double total = 0;
		for (Pago pagos : pago) {
			total += pagos.calcularImporte();
		}

		return total;
	}

	public double contarTipoPago(TipoPago t) {
		int total = 0;
		for (Pago pagos : pago) {
			if (pagos.getTipoPago() == t) {
				total++;
			}
		}
		return total;
	}

	public double calcularTotalIncremento() {
		double total = 0;
		for (Pago pagos : pago) {
			total += pagos.calcularIncremento();
		}
		return total;

	}
}
