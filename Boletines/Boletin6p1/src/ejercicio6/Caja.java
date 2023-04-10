package ejercicio6;

import java.util.LinkedList;

public class Caja {

	private int numeroCaja;
	private boolean estaAbierta;
	private LinkedList<Integer> colaCliente;

	public Caja(int numeroCaja) {

		this.numeroCaja = numeroCaja;
		estaAbierta = false;
		colaCliente = new LinkedList<Integer>();
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	private void setEstaAbierta(boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}

	public void abrirCaja() throws CajaException {
		if (estaAbierta) {
			throw new CajaException("La caja ya está abierta");
		} else {
			estaAbierta = true;
		}
	}

	public void cerrarCaja() throws CajaException {
		if (!estaAbierta) {
			throw new CajaException("La caja ya está cerrada");
		} else {
			if (tamannoColaCliente() != 0) {
				throw new CajaException("La caja tiene clientes");
			} else {
				estaAbierta = false;
			}
		}
	}

	public int tamannoColaCliente() {

		return colaCliente.size();
	}

	public void agregarNuevoClienteCaja(Integer cliente) throws CajaException {

		if (!estaAbierta) {
			throw new CajaException("La caja está cerrada");
		}
		colaCliente.add(cliente);
	}

	/*
	 * Creamos una variable de Integer clienteAtendido la cual va a ser para remover
	 * un cliente de la lista colaCliente. Comprobaremos si está abierta y si la
	 * lista está vacía y lanzaremos la escepcion pertinente.
	 * 
	 */
	public Integer atenderCliente() throws CajaException {
		int clienteAtendido = colaCliente.remove();

		if (!estaAbierta) {
			throw new CajaException("La caja está cerrada");
		}
		if (colaCliente.isEmpty()) {
			throw new CajaException("En la caja seleccionada no hay clientes");
		}

		return clienteAtendido;
	}

	@Override
	public String toString() {
		return "Caja [numeroCaja=" + numeroCaja + ", estaAbierta=" + estaAbierta + ", colaCliente=" + colaCliente + "]";
	}

}
