import excepciones.EmptyStackException;
import tda.Stack;

public class PilaEnlazada<E> implements Stack<E> {
    protected Nodo<E> head;
    protected int tamaño;

    public PilaEnlazada() {
        this.head = null;
        this.tamaño = 0;
    }

    public void push(E item) {
        this.head = new Nodo<E>(item, this.head);
        this.tamaño++;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Pila vacia");
        }
        E aux = this.head.getElemento();
        this.head = this.head.getSiguiente();
        this.tamaño--;
        return aux;
    }

    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException("Pila vacia");
        }
        return this.head.getElemento();
    }

    public int size() {
        return this.tamaño;
    }
}
