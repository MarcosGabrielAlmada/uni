package ar.edu.uns.cs.ed.tdas.tps.tp4;
import ar.edu.uns.cs.ed.tdas.Position;

public class DNodo<E> implements Position<E> {
    private E elemento;
    private DNodo<E> previo, siguiente;

    public DNodo(E item, DNodo<E> prev, DNodo<E> sig) {
        this.elemento = item;
        this.previo = prev;
        this.siguiente = sig;
    }

    public DNodo(E item) {
        this(item, null, null);
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public void setPrevio(DNodo<E> previo) {
        this.previo = previo;
    }

    public void setSiguiente(DNodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    public E getElemento() {
        return this.elemento;
    }

    public DNodo<E> getPrevio() {
        return this.previo;
    }

    public DNodo<E> getSiguiente() {
        return this.siguiente;
    }

    public E element() {
        return this.elemento;
    }

}

