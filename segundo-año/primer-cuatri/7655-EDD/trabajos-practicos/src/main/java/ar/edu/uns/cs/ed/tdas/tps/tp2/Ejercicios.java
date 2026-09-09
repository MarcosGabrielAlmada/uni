package ar.edu.uns.cs.ed.tdas.tps.tp2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ejercicios<A> {
    public Ejercicios() {
    }

    // EJERCICIO 1

    public A[] Invertir(A[] a) {
        Stack<A> pila = new Stack<A>();
        for (int i = 0; i < a.length; i++) {
            pila.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = pila.pop();
        }

        return a;
    }

    // EJERCICIO 2

    public Queue<Integer> soloImpares(Queue<Integer> cola1) {
        Queue<Integer> cola2 = new LinkedList<Integer>();
        Integer aux, capacity = cola1.size();
        for (int i = 0; i < capacity; i++) {
            aux = cola1.remove();
            if (aux % 2 == 1) {
                cola2.add(aux);
            }
        }

        return cola2;
    }

    // EJERCICIO 3

    public Stack<A> intercalar(Stack<A> p1, Stack<A> p2) {
        Stack<A> pila = new Stack<A>();
        int tamaño;

        if (p1.size() > p2.size()) {
            tamaño = p1.size();
        } else {
            tamaño = p2.size();
        }

        for (int i = 0; i < tamaño; i++) {
            if (p1.isEmpty() == false) {
                pila.push(p1.pop());
            }
            if (p2.isEmpty() == false) {
                pila.push(p2.pop());
            }
        }

        return pila;
    }

    // EJERCICIO 4

    public Integer elMayor(Queue<Integer> q) {
        Queue<Integer> qAux = new LinkedList<Integer>();
        Integer aux, mayor = null, capacity = q.size();

        if (q.isEmpty() == false) {
            mayor = q.remove();
            qAux.add(mayor);

            for (int i = 0; i < capacity - 1; i++) {
                aux = q.remove();
                qAux.add(aux);

                if (aux > mayor) {
                    mayor = aux;
                }
            }

            for (int i = 0; i < capacity; i++) {
                q.add(qAux.remove());
            }
        }

        return mayor;

    }

}
