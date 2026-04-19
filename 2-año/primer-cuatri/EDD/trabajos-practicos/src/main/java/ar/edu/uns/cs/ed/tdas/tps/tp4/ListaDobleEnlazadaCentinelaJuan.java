package ar.edu.uns.cs.ed.tdas.tps.tp4;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import java.util.Iterator;

public class ListaDobleEnlazadaCentinelaJuan<E> implements PositionList<E>{
    protected DNodo<E> header;
    protected DNodo<E> trailer;
    protected int tamanio;

    
    public ListaDobleEnlazadaCentinelaJuan(){
        header = new DNodo<E>(null);
        trailer = new DNodo<E>(null);
        header.setSiguiente(trailer);
        trailer.setPrevio(header);
        tamanio = 0;
    }

    public int size(){
        return tamanio;
    }

    public boolean isEmpty(){
        return tamanio == 0;
    }

    public Position<E> first() throws EmptyListException{
        if (isEmpty()) throw new EmptyListException("Lista vacía");
        return header.getSiguiente();
    }

    public Position<E> last(){
        if (isEmpty()) throw new EmptyListException("Lista vacía");
        return trailer.getPrevio();
    }

    private DNodo<E> checkPosition(Position<E> p ) {
        try {
            if ( p == null ) throw new InvalidPositionException("Posición nula");
            if (p.element() == null) throw new InvalidPositionException("p eliminada previamente");
            return (DNodo<E>) p; // Puede fallar si p es una posición que corresponde a un nodo de otro tipo de estructura de datos
        }
        catch( ClassCastException e ) { // Vengo acá porque falló el casting a Nodo
                throw new InvalidPositionException("p no es un nodo de lista");
        }
    }
    public Position<E> next(Position<E> p){
        DNodo<E> n = checkPosition(p); // Propaga InvalidPositionException
        if (isEmpty()) throw new InvalidPositionException("Lista vacía");
        if (n.getSiguiente() == trailer) throw new BoundaryViolationException("La posicion corresponde al ultimo elemento de la lista");
        return n.getSiguiente();
    }
    
    public Position<E> prev(Position<E> p){
        DNodo<E> n = checkPosition(p);
        if (isEmpty()) throw new InvalidPositionException("Lista vacía");
        if (n.getPrevio() == header) throw new BoundaryViolationException("La poisicon corresponde al primer elemento de la lista");
        return n.getPrevio();
    }

    public void addFirst(E element){
        DNodo<E> nuevo = new DNodo<E>(element);
        nuevo.setPrevio(header);
        nuevo.setSiguiente(header.getSiguiente());
        header.getSiguiente().setPrevio(nuevo);
        header.setSiguiente(nuevo);
        tamanio++;
    }

    public void addLast(E element){
        DNodo<E> nuevo = new DNodo<E>(element);
        nuevo.setPrevio(trailer.getPrevio());
        nuevo.setSiguiente(trailer);
        nuevo.getPrevio().setSiguiente(nuevo);
        trailer.setPrevio(nuevo);
        tamanio++;
    }

    public void addAfter(Position<E> p, E element){
        DNodo<E> pos = checkPosition(p);
        if (isEmpty()) throw new InvalidPositionException("Lista vacía");
        DNodo<E> nuevo = new DNodo<E>(element);
        nuevo.setPrevio(pos);
        nuevo.setSiguiente(pos.getSiguiente());
        pos.setSiguiente(nuevo);
        nuevo.getSiguiente().setPrevio(nuevo);
        tamanio++;
    }

    public void addBefore(Position<E> p, E element){
        DNodo<E> pos = checkPosition(p);
        if (isEmpty()) throw new InvalidPositionException("Lista vacía");
        DNodo<E> nuevo = new DNodo<E>(element);
        nuevo.setSiguiente(pos);
        nuevo.setPrevio(pos.getPrevio());
        pos.getPrevio().setSiguiente(nuevo);
        pos.setPrevio(nuevo);
        tamanio++;
    }

    public E remove(Position<E> p){
        DNodo<E> pos = checkPosition(p);
        if (isEmpty()) throw new InvalidPositionException("Lista vacía");
        E res = pos.element();
        pos.getPrevio().setSiguiente(pos.getSiguiente());
        pos.getSiguiente().setPrevio(pos.getPrevio());
        pos.setSiguiente(null);
        pos.setPrevio(null);
        return res;
    }

    public E set(Position<E> p, E element){
        DNodo<E> pos = checkPosition(p);
        if (isEmpty()) throw new InvalidPositionException("Lista vacía");
        E res = pos.element();
        pos.setElemento(element);
        return res;
    }



    public Iterator<E> iterator(){
        return new ElementIterator<E>(this);
    }

    public Iterable<Position<E>> positions(){
        PositionList<Position<E>> lista = new ListaDobleEnlazadaCentinelaJuan<>();
        DNodo<E> cursor = header.getSiguiente();
        while (cursor != trailer){
            lista.addLast(cursor);
            cursor = cursor.getSiguiente();
        }
        return lista;
    }
}