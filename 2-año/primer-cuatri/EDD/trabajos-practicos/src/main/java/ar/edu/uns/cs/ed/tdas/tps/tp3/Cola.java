package ar.edu.uns.cs.ed.tdas.tps.tp3;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;

public class Cola<E> implements Queue<E> {
    private E[] arreglo;
    private int inicio;
    private int fin;
    
    public Cola() {
        this(10);
    }
    
    public Cola(int tam) {
        this.arreglo = (E[]) new Object[tam];
        this.inicio = 0;
        this.fin = 0;
    }
    
    public int size() {
        return this.fin - this.inicio;
    }
    
    public boolean isEmpty() {
        return this.fin == this.inicio;
    }
    
    public E front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cola vacia");
        }
        return this.arreglo[inicio];
    }
    
    public void enqueue(E element) {
        if (this.fin == this.arreglo.length) {
            E[] aux = (E[]) new Object[this.arreglo.length + 10];
            for (int i = 0; i < this.fin - this.inicio; i++) {
                aux[i] = this.arreglo[this.inicio + i];
            }
            this.fin = this.fin - this.inicio;
            this.inicio = 0;
            this.arreglo = aux;
        }
        this.arreglo[this.fin++] = element;
    }
    
    public E dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Cola vacia");
        }
        E valor = this.arreglo[this.inicio];
        this.arreglo[this.inicio++] = null;
        return valor;
    }
}


















// gracias claudio