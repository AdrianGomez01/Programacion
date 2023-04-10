package ejercicio6;

import java.util.Arrays;
import java.util.Iterator;

public class GranAlmacen {

	private static final int MAXIMO_DE_CAJAS = 20;
	private static int numeroDeClientes = 0;
	private Caja cajas[];

	public GranAlmacen() {

		cajas = new Caja[MAXIMO_DE_CAJAS];

		inicializarCajas();
	}

	private void inicializarCajas() {

		int i;

		for (i = 0; i < cajas.length; i++) {
			cajas[i] = new Caja((i + 1));
		}
	}

	/*
	 * Método para abrir la caja, comprobando que la caja existe segun su número de
	 * caja y abriendola en consecuencia, añadiendo un -1 a la posición ya que al
	 * crearla empieza por la 0 con nombre 1
	 */
	public void abrirCaja(int numeroCaja) throws CajaException {

		if (numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS) {
			throw new CajaException("La caja introducida no existe");
		}
		cajas[numeroCaja - 1].abrirCaja();
		;

	}

	public void cerrarCaja(int numeroCaja) throws CajaException {

		if (numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS) {
			throw new CajaException("La caja introducida no existe");
		}
		cajas[numeroCaja - 1].cerrarCaja();
		;

	}

	public String nuevoCliente() throws CajaException {

		int cajaConMenosClientes = cajaMenosCliente();
		cajas[cajaConMenosClientes - 1].agregarNuevoClienteCaja(++numeroDeClientes);

		return "Es usted el cliente número " + numeroDeClientes + " y debe ir a la caja número " + cajaConMenosClientes
				+ ".";

	}

	/*
	 * Este método acepta por parámetro una caja en la cual se va a atender al
	 * cliente, comprobando que exista la caja en cuestion. Devuelve un entero
	 * "clienteAtendido" de la clase Caja y se retira de la cola.
	 */
	//TODO no sé donde devolver el mensaje porque el metodo devuelve un int y no deberia hacer un
	//syso en esta clase. Consultarlo en clase
	public int atenderCliente(int numeroCaja) throws CajaException {

		//TODO Preguntar si la condicion de este IF no convendría sacarla a un metodo a parte que devuelva
		//un boolean si existe o no, ya que se usa en este metodo y en cerrar caja.
		if (numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS) {
			throw new CajaException("La caja introducida no existe");
		}
		return cajas[numeroCaja - 1].atenderCliente();
	}

	@Override
	public String toString() {
		return "GranAlmacen [cajas=" + Arrays.toString(cajas) + "]";
	}

	/**
	 * 
	 * @return Devuelve el número de caja que tiene menos clientes
	 * @throws CajaException Si todas las cajas están cerradas
	 */

	private int cajaMenosCliente() throws CajaException {

		int numClientes = Integer.MAX_VALUE;
		int numCaja = 0;
		for (int i = 0; i < cajas.length; i++) {
			if (cajas[i].isEstaAbierta() && cajas[i].tamannoColaCliente() < numClientes) {
				numCaja = cajas[i].getNumeroCaja();
				numClientes = cajas[i].tamannoColaCliente();
			}
		}
		if (numCaja == 0) {
			throw new CajaException("No hay cajas abiertas");
		}
		return numCaja;

	}

}
