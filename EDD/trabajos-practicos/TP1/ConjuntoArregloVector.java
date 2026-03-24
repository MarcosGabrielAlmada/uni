import java.util.Vector;

public class ConjuntoArregloVector<E> implements Conjunto<E>{
    private Vector<E> conjunto;

    public ConjuntoArregloVector(int i) {
        this.conjunto = new Vector<>(i);
    }

    public int size() {
        return this.conjunto.size();
    }

    public int capacity() {
        return conjunto.capacity();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public E get(int i) {
        return this.conjunto.get(i);
    }

    public void put(E elem) {
        this.conjunto.add(elem);
    }

    public boolean pertenece(E elem) {
        return this.conjunto.contains(elem);
    }

    public Conjunto<E> interseccion(Conjunto<E> c) {
        Conjunto<E> res = new ConjuntoArreglo<E>(this.capacity());
        for (int i = 0; i < this.capacity(); i++) {
            if (c.pertenece(this.get(i))) {
                res.put(this.get(i));
            }
        }

        return res;
    }
}

