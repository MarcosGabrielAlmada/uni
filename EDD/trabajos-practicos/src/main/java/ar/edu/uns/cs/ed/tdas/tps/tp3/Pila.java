package ar.edu.uns.cs.ed.tdas.tps.tp3;

import ar.edu.uns.cs.ed.tdas.tdapila.Stack;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyStackException;

public class Pila<E> implements Stack<E>{
    private E[] arreglo;
    private int cant;

    public Pila() {
        this.arreglo = (E[]) new Object[10];
        this.cant = 0;
    }

    public Pila(int tam) {
        this.arreglo = (E[]) new Object[tam];
        this.cant = 0;
    }

    public int size() {
        return this.cant;
    }

	public boolean isEmpty() {
        return this.cant == 0;
    }

	public E top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Pila vacia");
        }
        return this.arreglo[this.cant-1];
    }

	public void push(E element) {
        if (this.cant <= this.arreglo.length) {
            this.arreglo[this.cant++] = element;
        } else {
            E[] aux = (E[]) new Object[this.cant + 10];
            for(int i = 0; i < this.cant; i++) {
                aux[i] = this.arreglo[i];
            }
            aux[this.cant++] = element;
            this.arreglo = aux;
        }
    }

	public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Pila vacia");
        }
        this.cant--;
        E aux = this.arreglo[this.cant];
        this.arreglo[this.cant] = null;
        return aux;
    }
}