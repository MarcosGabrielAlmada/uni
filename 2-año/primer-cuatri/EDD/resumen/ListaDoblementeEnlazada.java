import excepciones.BoundaryViolationException;
import excepciones.EmptyListException;
import excepciones.InvalidPositionException;
import tda.PositionList;
import tda.Position;
import java.util.Iterator;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {
    protected DNodo<E> head, tail;
    protected int tamaño;

    public ListaDoblementeEnlazada() {
        this.head = new DNodo<E>(null);
        this.tail = new DNodo<E>(null, this.head, null);
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
        DNodo<E> nodo = this.checkPosition(p);

        if (nodo.getSiguiente() == this.last()) {
            throw new BoundaryViolationException("Ultimo elemento");
        }

        return nodo.getSiguiente();

    }

    public Position<E> prev(Position<E> p) {
        DNodo<E> nodo = this.checkPosition(p);

        if (nodo == first()) {
            throw new BoundaryViolationException("Primer elemento");
        }

        return nodo.getPrevio();
    }

    public void addFirst(E element) {
        DNodo<E> nuevo = new DNodo<E>(element, this.head, this.head.getSiguiente());
        this.head.setSiguiente(nuevo);
        nuevo.getSiguiente().setPrevio(nuevo);
        this.tamaño++;
    }

    public void addLast(E element) {
        DNodo<E> nuevo = new DNodo<E>(element, this.tail.getPrevio(), this.tail);
        this.tail.setPrevio(nuevo);
        nuevo.getPrevio().setSiguiente(nuevo);
        this.tamaño++;
    }

    public void addAfter(Position<E> p, E element) {
        DNodo<E> nodo = this.checkPosition(p);
        DNodo<E> nuevo = new DNodo<E>(element, nodo, nodo.getSiguiente());
        nodo.setSiguiente(nuevo);
        nuevo.getSiguiente().setPrevio(nuevo);
        this.tamaño++;
    }

    public void addBefore(Position<E> p, E element) {
        DNodo<E> nodo = this.checkPosition(p);
        DNodo<E> nuevo = new DNodo<E>(element, nodo.getPrevio(), nodo);
        nodo.setPrevio(nuevo);
        nuevo.getPrevio().setSiguiente(nuevo);
        this.tamaño++;
    }

    public E remove(Position<E> p) {
        DNodo<E> nodo = this.checkPosition(p);

        if (p == first()) {
            this.head = nodo.getSiguiente();
        } else {
            nodo.getPrevio().setSiguiente(nodo.getSiguiente());
            nodo.getSiguiente().setPrevio(nodo.getPrevio());
        }
        
        this.tamaño--;

        return nodo.element();
    }

    public E set(Position<E> p, E element) {
        DNodo<E> nodo = this.checkPosition(p);
        E viejo = nodo.element();
        nodo.setElemento(element);
        return viejo;
    }

    public Iterator<E> iterator() {
        return new ElementIterator<E>(this);
    }

    public Iterable<Position<E>> positions() {
        ListaDoblementeEnlazada<Position<E>> lista = new ListaDoblementeEnlazada<Position<E>>();        
        DNodo<E> nodo = this.head.getSiguiente();

        while (nodo != this.tail) {
            lista.addLast(nodo);
            nodo = nodo.getSiguiente();
        }
        
        return lista;
    }

    private DNodo<E> checkPosition(Position<E> p) {
        try {
            if (p == null)
                throw new InvalidPositionException("Posicion nula");
            if (p.element() == null)
                throw new InvalidPositionException("p eliminada previamente");
            return (DNodo<E>) p;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("p no es un nodo de la lista");
        }
    }
}
