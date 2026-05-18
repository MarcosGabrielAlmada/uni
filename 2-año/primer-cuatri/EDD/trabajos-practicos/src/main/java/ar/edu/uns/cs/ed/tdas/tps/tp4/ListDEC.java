package ar.edu.uns.cs.ed.tdas.tps.tp4;
import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class ListDEC<E> implements PositionList<E> {
    protected DNode<E> head, tail;
    protected int tamaño;

    public ListDEC() {
        this.head = new DNode<E>(null);
        this.tail = new DNode<E>(null, this.head, null);
        this.head.setSiguiente(this.tail);
        this.tamaño = 0;
    }

    public int size() {
        return this.tamaño;
    }

    public boolean isEmpty() {
        return this.head.getSiguiente() == this.tail;
    }

    public Position<E> first() {
        if (isEmpty()) {
            throw new EmptyListException("Lista vacia");
        }
        return this.head.getSiguiente();
    }

    public Position<E> last() {
        if (isEmpty()) {
            throw new EmptyListException("Lista vacia");
        }
        return this.tail.getPrevio();
    }

    public Position<E> next(Position<E> p) {
        DNode<E> nodo = this.checkPosition(p);

        if (nodo == this.last()) {
            throw new BoundaryViolationException("Ultimo elemento");
        }

        return nodo.getSiguiente();

    }

    public Position<E> prev(Position<E> p) {
        DNode<E> nodo = this.checkPosition(p);

        if (nodo == first()) {
            throw new BoundaryViolationException("Primer elemento");
        }

        return nodo.getPrevio();
    }

    public void addFirst(E element) {
        DNode<E> nuevo = new DNode<E>(element, this.head, this.head.getSiguiente());
        this.head.setSiguiente(nuevo);
        nuevo.getSiguiente().setPrevio(nuevo);
        this.tamaño++;
    }

    public void addLast(E element) {
        DNode<E> nuevo = new DNode<E>(element, this.tail.getPrevio(), this.tail);
        this.tail.setPrevio(nuevo);
        nuevo.getPrevio().setSiguiente(nuevo);
        this.tamaño++;
    }

    public void addAfter(Position<E> p, E element) {
        DNode<E> nodo = this.checkPosition(p);
        DNode<E> nuevo = new DNode<E>(element, nodo, nodo.getSiguiente());
        nodo.setSiguiente(nuevo);
        nuevo.getSiguiente().setPrevio(nuevo);
        this.tamaño++;
    }

    public void addBefore(Position<E> p, E element) {
        DNode<E> nodo = this.checkPosition(p);
        DNode<E> nuevo = new DNode<E>(element, nodo.getPrevio(), nodo);
        nodo.setPrevio(nuevo);
        nuevo.getPrevio().setSiguiente(nuevo);
        this.tamaño++;
    }

    public E remove(Position<E> p) {
        DNode<E> nodo = this.checkPosition(p);

        nodo.getPrevio().setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setPrevio(nodo.getPrevio());
        nodo.setElemento(null);

        this.tamaño--;

        return nodo.element();
    }

    public E set(Position<E> p, E element) {
        DNode<E> nodo = this.checkPosition(p);
        E viejo = nodo.element();
        nodo.setElemento(element);
        return viejo;
    }

    public Iterator<E> iterator() {
        return new ElementIterator<E>(this);
    }

    public Iterable<Position<E>> positions() {
        ListDEC<Position<E>> lista = new ListDEC<Position<E>>();
        DNode<E> nodo = this.head.getSiguiente();

        while (nodo != this.tail) {
            lista.addLast(nodo);
            nodo = nodo.getSiguiente();
        }

        return lista;
    }

    private DNode<E> checkPosition(Position<E> p) {
        try {
            if (p == null)
                throw new InvalidPositionException("Posicion nula");
            if (p.element() == null)
                throw new InvalidPositionException("p eliminada previamente");
            return (DNode<E>) p;
        } catch (InvalidPositionException e) {
            throw new InvalidPositionException("p no es un nodo de la lista");
        }
    }

    public String toString() {
        String res = "";
        DNode<E> cursor = this.head.getSiguiente();
        while(cursor != this.tail) {
            res = res + "[" + cursor.getElemento() + "]";
            cursor = cursor.getSiguiente();
        }
        return res;
    }

    public void ejercicio2 (E e1, E e2) {
        if (isEmpty()) {
            this.addFirst(e1);
            this.addFirst(e2);
        } else {
            this.addAfter(this.first(), e1);
            this.addBefore(this.last(), e2);
        }
    }
}
