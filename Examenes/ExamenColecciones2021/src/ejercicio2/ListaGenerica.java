package ExamenColecciones2021.src.ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaGenerica<T extends Comparable<T>> {

	private LinkedList<T> lista;

	public ListaGenerica() {
		lista = new LinkedList<T>();
	}

	public void annadirElemento(T elemento) {
		lista.add(elemento);
	}

	public ListaGenerica<T> listaHastaElemento(T elementoBuscado) {

		ListaGenerica<T> listaHastaElemento = new ListaGenerica<T>();

		for (T elemento : lista) {
			listaHastaElemento.annadirElemento(elemento);
			if (elemento.equals(elementoBuscado)) {
				return listaHastaElemento;
			}
		}
		return null;
	}

	public ListaGenerica<T> elementosMenores(T elementoReferencia) {
		ListaGenerica<T> listaMenores = new ListaGenerica<>();
		Iterator<T> it = this.lista.iterator();
		while (it.hasNext()) {
			T elementoActual = it.next();
			if (elementoActual.compareTo(elementoReferencia) < 0) {
				listaMenores.annadirElemento(elementoReferencia);
			}
		}
		return listaMenores;
	}

	@Override
	public String toString() {
		return "ListaGenerica=" + lista;
	}

}
