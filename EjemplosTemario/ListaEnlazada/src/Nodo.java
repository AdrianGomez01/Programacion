public class Nodo<E> {
    /*
    Siguiente y anterior son apuntadores a los respectivos nodos. Si contienen valor null
    es que no apuntan a nada y será el último o el primero respectivamente.
     */
    private Nodo<E> sigueinte, anterior;
    private E elemento;

    public Nodo(E elemento) {
        this.sigueinte = sigueinte;
        this.anterior = anterior;
        this.elemento = elemento;
    }

    public Nodo<E> getSigueinte() {
        return sigueinte;
    }

    public Nodo<E> getAnterior() {
        return anterior;
    }

    public E getElemento() {
        return elemento;
    }

    public void setSigueinte(Nodo<E> sigueinte) {
        this.sigueinte = sigueinte;
    }

    public void setAnterior(Nodo<E> anterior) {
        this.anterior = anterior;
    }
}
