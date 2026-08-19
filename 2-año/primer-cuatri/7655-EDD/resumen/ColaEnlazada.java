import excepciones.EmptyStackException;
import tda.Queue;

public class ColaEnlazada<E> implements Queue<E> {
    protected Nodo<E> head, tail;
    protected int tamaño;

    public ColaEnlazada() {
        this.head = null;
        this.tail = null;
        this.tamaño = 0;
    }

    public void enqueue(E item) {
        Nodo<E> aux = new Nodo<E>(item);
        if (isEmpty()) {
            this.head = aux;
        } else {
            this.tail.setSiguiente(aux);
        }
        this.tail = aux;
        this.tamaño++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException("Cola vacia");
        }
        E aux = this.head.getElemento();
        this.head = this.head.getSiguiente();
        if (this.head == null) {
            this.tail = null;
        }
        this.tamaño--;
        return aux;
    }

    public E front() {
        if (isEmpty()) {
            throw new EmptyStackException("Cola vacia");
        }
        return this.head.getElemento();
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.tamaño;
    }
}