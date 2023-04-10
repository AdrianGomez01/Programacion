import java.lang.reflect.InaccessibleObjectException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<E> implements List<E> {

	private Nodo<E> primerElemento;
	private Nodo<E> ultimoElemento;
	private int numElementos;

	public ListaEnlazada() {
		this.numElementos = 0;
	}

	@Override
	public int size() {
		return numElementos;
	}

	@Override
	public boolean isEmpty() {

		return numElementos == 0;
	}

	@Override
	public boolean contains(Object o) {
		return this.indexOf(o) != -1;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListaEnlazadaIterator();
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {

		Nodo<E> nuevoNodo = new Nodo<E>(e);
		if (this.isEmpty()) {
			primerElemento = nuevoNodo;
		} else {
			ultimoElemento.setSigueinte(nuevoNodo);
			nuevoNodo.setAnterior(ultimoElemento);
		}
		ultimoElemento = nuevoNodo;
		numElementos++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// Guardamos en una variable el indexOf del objeto o , para no tener que
		// realizar la llamada varias veces.
		int posicionElemento = this.indexOf(o);
		if (posicionElemento != -1) {
			Nodo<E> nodoActual = primerElemento;
			for (int i = 0; i <= posicionElemento; i++) {
				if (i == posicionElemento) {
					/*
					 * Comprobamos si es el primer elemento, y marcamos el apuntador a null
					 * actualizando el apuntador de primerElemento.
					 */
					if (nodoActual.getAnterior() != null) {
						nodoActual.getAnterior().setSigueinte(nodoActual.getSigueinte());
					} else {
						nodoActual.getSigueinte().setAnterior(null);
						primerElemento = nodoActual.getSigueinte();
					}
					/*
					 * Comprobamos si es el ultimo elemento, y marcamos el apuntador a null
					 * actualizando el apuntador de ultimoElemento.
					 */
					if (nodoActual.getSigueinte() != null) {
						nodoActual.getSigueinte().setAnterior(nodoActual.getAnterior());
					} else {
						nodoActual.getAnterior().setSigueinte(null);
						ultimoElemento = nodoActual.getAnterior();
					}
					numElementos--;

				} else {
					nodoActual = nodoActual.getSigueinte();
				}
			}

		}
		// Comprueba si está el elemento, si está devuelve true ya que lo puede elminar,
		// si no lo encuentra da false ya que no puede eliminar un elemento que no
		// existe.
		return posicionElemento != -1;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public E get(int index) {

		return getNodo(index).getElemento();
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void add(int index, E element) {
		// Comprobamos que el indice no se pase del num de elementos, para no dejar
		// huecos. Depues cambiamos los apuntadores de los nodos colindantes y los 2 del
		// prropio nodo. Si el indice es igual al numelementos se añade directamente al
		// final.
		if (index >= 0 && index <= numElementos) {
			if (index == numElementos) {
				add(element);
			} else {
				Nodo<E> nuevoNodo = new Nodo<>(element);
				Nodo<E> nodoPosicion = getNodo(index);
				// Referencia el nuevo nodo indicando la posicion anterior y siguiente
				nuevoNodo.setAnterior(nodoPosicion.getAnterior());
				nuevoNodo.setSigueinte(nodoPosicion);

				// Controlamos que no es el primero al añadirlo, si lo es actualizamos la
				// variable de primerelemento que tenemos para guardarlo.
				if (nodoPosicion.getAnterior() != null) {
					// Cogemos la referencia del nodo anterior antes de introducir el nuevo y se la
					// damos al nuevo nodo.
					nodoPosicion.getAnterior().setSigueinte(nuevoNodo);
				} else {
					primerElemento = nuevoNodo;
				}
				// Actualizamos el apuntador del nodo anterior a la introduccion del nuevo nodo
				// a nuestro nuevo nodo.
				nodoPosicion.setAnterior(nuevoNodo);
				numElementos++;
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public E remove(int index) {

		return null;
	}

	@Override
	public int indexOf(Object o) {
		int indice = -1;
		int indiceActual = 0;
		Nodo<E> nodoActual = primerElemento;
		while (nodoActual != null && indice == -1) {
			if (nodoActual.getElemento() == null) {
				if (o == null) {
					indice = indiceActual;
				}
			} else if (nodoActual.getElemento().equals(o)) {
				indice = indiceActual;
			}
			nodoActual = nodoActual.getSigueinte();
			indiceActual++;

		}
		return indice;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	private Nodo<E> getNodo(int indice) {
		Nodo<E> nodoActual;

		if (indice >= 0 && indice < numElementos) {
			/*
			 * Dividimos con el if el num de elementos a la mitad para mayor eficiencia,
			 * controlando el siguiente o el anterior dependiendo de si empezamos por el
			 * principio o por el final
			 */
			if (indice < (numElementos >> 1)) {
				nodoActual = primerElemento;
				for (int i = 0; i < indice; i++) {
					nodoActual = nodoActual.getSigueinte();
				}
			} else {
				nodoActual = ultimoElemento;
				for (int i = (numElementos - 1); i > indice; i--) {
					nodoActual = nodoActual.getAnterior();
				}
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		return nodoActual;
	}

	protected class ListaEnlazadaIterator implements Iterator<E> {

		Nodo<E> ultimoNodoDevuelto;
		int numeroElementosDevueltos;

		public ListaEnlazadaIterator() {
			numeroElementosDevueltos = 0;
		}

		/*
		 * Primera solucion del metodo hasNext.
		 * 
		 * @Override public boolean hasNext() {
		 * 
		 * if (ultimoNodoDevuelto == null) { return primerElemento != null; } else {
		 * return ultimoNodoDevuelto.getSigueinte() != null; }
		 * 
		 * }
		 */

		@Override
		public boolean hasNext() {

			return numeroElementosDevueltos < numElementos;

		}

		@Override
		public E next() {
			if (ultimoNodoDevuelto == null) {
				ultimoNodoDevuelto = primerElemento;
			} else {
				ultimoNodoDevuelto = ultimoNodoDevuelto.getSigueinte();
			}
			// Si aún despues de actualizarse ultimoNodoDevuelto es nulo, controlamos la
			// excepcion. Puede darse si se llama a Next sin llamar previamente a hasNext.
			if (ultimoNodoDevuelto == null) {
				throw new NoSuchElementException("No hay siguiente elemento");
			}
			numeroElementosDevueltos++;
			return ultimoNodoDevuelto.getElemento();
		}

	}

}
