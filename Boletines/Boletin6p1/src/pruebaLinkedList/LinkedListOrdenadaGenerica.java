package pruebaLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListOrdenadaGenerica<T extends Comparable<T>> {

	LinkedList<T> lista = new LinkedList<>();

	public static void main(String[] args) {

		LinkedListOrdenadaGenerica<Integer> l1 = new LinkedListOrdenadaGenerica<>();
		LinkedListOrdenadaGenerica<Integer> l2 = new LinkedListOrdenadaGenerica<>();

		l1.insertarEnOrden(4);
		l1.insertarEnOrden(0);
		l1.insertarEnOrden(8);
		l1.insertarEnOrden(2);
		l1.insertarEnOrden(4);

		l2.insertarEnOrden(9);
		l2.insertarEnOrden(3);
		l2.insertarEnOrden(1);
		l2.insertarEnOrden(0);
		l2.insertarEnOrden(5);

		for (Integer i : l1.getLista()) {
			System.out.println(i);
		}

		/*
		 * for (Integer i : l2.getLista()) { System.out.println(i); }
		 */
	}

	public void insertarEnOrden(T i) {
		Iterator<T> itr = lista.iterator();
		int posActual = 0;
		boolean anhadido = false;

		while (itr.hasNext() && !anhadido) {
			if (itr.next().compareTo(i) >= 0) {
				anhadido = true;
			} else {
				posActual++;
			}
		}
		lista.add(posActual, i);
	}

	public LinkedList<T> getLista() {
		return lista;
	}

}
