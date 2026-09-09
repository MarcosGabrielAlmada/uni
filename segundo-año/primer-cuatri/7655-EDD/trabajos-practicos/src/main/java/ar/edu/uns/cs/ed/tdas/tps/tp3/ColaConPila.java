package ar.edu.uns.cs.ed.tdas.tps.tp3;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import java.util.Stack;

public class ColaConPila<E> implements Queue<E>{
    private Stack<E> pila;
    
    public ColaConPila() {
        pila = new Stack<E>();
    }

    public int size() {
        return pila.size();
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public E front() {
        pila = invertir(pila);
        E front = pila.peek();
        pila = invertir(pila);

        return front;
    }

    public void enqueue(E element) {
        pila.push(element);
    }

    public E dequeue() {
        pila = invertir(pila);
        E aux = pila.pop();
        pila = invertir(pila);
        
        return aux;
    }

    private Stack<E> invertir(Stack<E> pila) {
       Stack<E> aux = new Stack<E>();
        for (int i = 0; i < pila.size(); i++) {
            aux.push(pila.pop());
        }

        return aux; 
    }
}
