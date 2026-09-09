import excepciones.BoundaryViolationException;
import excepciones.EmptyListException;
import excepciones.InvalidPositionException;
import tda.PositionList;
import tda.Position;
import java.util.Iterator;

public class ListaSE<E> implements PositionList<E> {
    protected Nodo<E> head;
    protected int tamaño;

    public ListaSE() {
        this.head = null;
        this.tamaño = 0;
    }

    public int size() {
        return this.tamaño;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Position<E> first() {
        if (isEmpty()) {
            throw new EmptyListException("Lista vacia");
        }
        return this.head;
    }

    public Position<E> last() {
        if (isEmpty()) {
            throw new EmptyListException("Lista vacia");
        }
        Nodo<E> aux = this.head;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    public Position<E> next(Position<E> p) {
        Nodo<E> nodo = this.checkPosition(p);

        if (nodo.getSiguiente() == null) {
            throw new BoundaryViolationException("Ultimo elemento");
        }

        return nodo.getSiguiente();

    }

    public Position<E> prev(Position<E> p) {
        this.checkPosition(p);
        if (p == first()) {
            throw new BoundaryViolationException("Primer elemento");
        }

        Nodo<E> nodo = this.head;

        while (nodo.getSiguiente() != null && nodo.getSiguiente() != nodo) {
            nodo = nodo.getSiguiente();
        }

        if (nodo.getSiguiente() == null) {
            throw new InvalidPositionException("Posicion invalida");
        }

        return nodo;
    }

    public void addFirst(E element) {
        this.head = new Nodo<E>(element, this.head);
        this.tamaño++;
    }

    public void addLast(E element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Nodo<E> nodo = this.head;
            while (nodo.getSiguiente() != null) {
                nodo = nodo.getSiguiente();
            }
            nodo.setSiguiente(new Nodo<E>(element));
            this.tamaño++;
        }
    }

    public void addAfter(Position<E> p, E element) {
        Nodo<E> nodo = this.checkPosition(p);
        Nodo<E> aux = new Nodo<E>(element, nodo.getSiguiente());
        nodo.setSiguiente(aux);
        this.tamaño++;
    }

    public void addBefore(Position<E> p, E element) {
        this.checkPosition(p);
        if (p == this.head) {
            addFirst(element);
        } else {
            addAfter(prev(p), element);
        }
    }

    public E remove(Position<E> p) {
        Nodo<E> nodo = this.checkPosition(p);

        if (p == first()) {
            this.head = nodo.getSiguiente();
        } else {
            checkPosition(prev(nodo)).setSiguiente(nodo.getSiguiente());
        }

        this.tamaño--;

        return p.element();
    }

    public E set(Position<E> p, E element) {
        Nodo<E> nodo = this.checkPosition(p);
        E aux = nodo.element();
        nodo.setElemento(element);
        return aux;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public Iterable<Position<E>> positions() {
        return null;
    }

    private Nodo<E> checkPosition(Position<E> p) {
        try {
            if (p == null)
                throw new InvalidPositionException("Posicion nula");
            if (p.element() == null)
                throw new InvalidPositionException("p eliminada previamente");
            return (Nodo<E>) p;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("p no es un nodo de la lista");
        }
    }
}
