package Tema6.src.pruebaLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class PruebaLinkedListOrdenada {

	LinkedList<Integer> lista = new LinkedList<>();

	public static void main(String[] args) {

		PruebaLinkedListOrdenada l = new PruebaLinkedListOrdenada();

		l.insertarEnOrden(4);
		l.insertarEnOrden(0);
		l.insertarEnOrden(8);
		l.insertarEnOrden(2);
		l.insertarEnOrden(4);
		
		for (Integer i : l.getLista()) {
			System.out.println(i);
		}
		
	}

	public void insertarEnOrden(Integer i) {
		Iterator<Integer> num = lista.iterator();
		int posActual = 0;
		boolean anhadido = false;

		while (num.hasNext() && !anhadido) {
			if (num.next() > i) {
				anhadido = true;
			} else {
				posActual++;
			}
		}
		lista.add(posActual, i);
	}

	
	public LinkedList<Integer> getLista() {
		return lista;
	}
}
