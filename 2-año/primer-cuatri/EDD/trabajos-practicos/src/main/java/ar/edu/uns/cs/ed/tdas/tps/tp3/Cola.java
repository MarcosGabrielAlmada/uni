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
        return (this.arreglo.length - this.inicio + this.fin) % this.arreglo.length;
    }
	
	public boolean isEmpty() {
        return this.fin == 0;
    }
	
	public E front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cola vacia");
        }
        return this.arreglo[fin-1];

    }
	
	public void enqueue(E element) {
        if (this.fin == this.arreglo.length) {
            if (this.inicio > 0) {
                this.fin = 0;
            } else {
                E[] aux = (E[]) new Object[this.arreglo.length + 10];
                for (int i = 0; i < this.arreglo.length; i++) {
                    aux[i] = this.arreglo[i];
                }
                this.inicio += 10;
                this.arreglo = aux;
            }
        } else if (this.fin == this.inicio && this.arreglo[this.fin] != null) {
            E[] aux = (E[]) new Object[this.arreglo.length + 10];
            for (int i = 0; i < this.arreglo.length; i++) {
                if (i < this.inicio) {
                    aux[i] = this.arreglo[i];
                } else {
                    aux[i + 10] = this.arreglo[i];
                }
            }
            this.inicio += 10;
            this.arreglo = aux;
        }
        this.arreglo[this.fin++] = element;
    }
	
	
	public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cola vacia");
        }

        E aux = this.arreglo[this.inicio];
        this.arreglo[this.inicio++] = null;
        
        if (this.inicio == this.arreglo.length) {
            this.inicio = 0;
        }

        else if (this.inicio == this.fin) {
            this.inicio = 0;
            this.fin = 0;
        }
        return aux;
    }
}
