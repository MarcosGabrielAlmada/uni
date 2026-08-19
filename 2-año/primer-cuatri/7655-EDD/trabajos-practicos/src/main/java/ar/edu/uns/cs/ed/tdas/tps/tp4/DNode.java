package ar.edu.uns.cs.ed.tdas.tps.tp4;
import ar.edu.uns.cs.ed.tdas.Position;

public class DNode<E> implements Position<E> {
    private E elemento;
    private DNode<E> previo, siguiente;

    public DNode(E item, DNode<E> prev, DNode<E> sig) {
        this.elemento = item;
        this.previo = prev;
        this.siguiente = sig;
    }

    public DNode(E item) {
        this(item, null, null);
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public void setPrevio(DNode<E> previo) {
        this.previo = previo;
    }

    public void setSiguiente(DNode<E> siguiente) {
        this.siguiente = siguiente;
    }

    public E getElemento() {
        return this.elemento;
    }

    public DNode<E> getPrevio() {
        return this.previo;
    }

    public DNode<E> getSiguiente() {
        return this.siguiente;
    }

    public E element() {
        return this.elemento;
    }

}

