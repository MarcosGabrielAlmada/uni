import tda.Position;

public class Nodo<E> implements Position<E> {
    private E elemento;
    private Nodo<E> siguiente;

    public Nodo(E item, Nodo<E> sig) {
        this.elemento = item;
        this.siguiente = sig;
    }

    public Nodo(E item) {
        this(item, null);
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    public E getElemento() {
        return this.elemento;
    }

    public Nodo<E> getSiguiente() {
        return this.siguiente;
    }

    public E element() {
        return this.elemento;
    }

}
