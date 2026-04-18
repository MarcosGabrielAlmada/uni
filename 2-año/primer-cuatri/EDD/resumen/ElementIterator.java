import java.util.Iterator;
import tda.PositionList;
import tda.Position;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E> {
    protected PositionList<E> lista;
    protected Position<E> cursor;

    public ElementIterator(PositionList<E> l) {
        this.lista = l;
        this.cursor = this.lista.isEmpty() ? null : this.lista.first();
    }

    public boolean hasNext() {
        return this.cursor != null;
    }

    public E next() {
        if (this.cursor == null) {
            throw new NoSuchElementException("Iterador de lista: No hay siguiente");
        }
        E resultado = this.cursor.element();
        this.cursor = this.cursor == this.lista.last() ? null : this.lista.next(this.cursor);
        return resultado;
    }

    public void remove() {
    }
}