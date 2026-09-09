package ar.edu.uns.cs.ed.tdas.tps.tp4;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicios {
    // EJERCICIO 3

    public <E> boolean e3a(PositionList<E> l, E e1) {
        Iterator<E> it = l.iterator();

        while (it.hasNext()) {
            if (it.next().equals(e1))
                return true;
        }
        return false;
    }

    public <E> int e3b(PositionList<E> l, E e1) {
        Iterator<E> it = l.iterator();
        int cant = 0;

        while (it.hasNext()) {
            if (it.next().equals(e1))
                cant++;
        }
        return cant;
    }

    public <E> boolean e3c(PositionList<E> l, E x, int n) {
        Iterator<E> it = l.iterator();
        int cant = 0;

        while (it.hasNext()) {
            if (it.next() == x && ++cant == n)
                return true;
        }
        return false;
    }


    // EJERCICIO 4

    public <E> PositionList<E> e4(PositionList<E> l) {
        PositionList<E> nuevaList = new ListDEC<E>();
        for (E item : l) {
            nuevaList.addLast(item);
            nuevaList.addLast(item);
        }
        return nuevaList;
    }
}
