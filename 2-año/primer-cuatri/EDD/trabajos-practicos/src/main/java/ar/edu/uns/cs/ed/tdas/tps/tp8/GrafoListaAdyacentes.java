package ar.edu.uns.cs.ed.tdas.tps.tp8;

import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEdgeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidVertexException;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;

public class GrafoListaAdyacentes<V, E> implements Graph<V, E> {

    protected PositionList<Vertice<V, E>> nodos;
    protected PositionList<Arco<V, E>> arcos;

    public GrafoListaAdyacentes() {
        this.nodos = new ListDEC<Vertice<V, E>>();
        this.arcos = new ListDEC<Arco<V, E>>();
    }

    // ── vertices() – O(n) ──────────────────────────────────────────────────────
    public Iterable<Vertex<V>> vertices() {
        PositionList<Vertex<V>> lista = new ListDEC<Vertex<V>>();
        for (Vertex<V> v : this.nodos) {
            lista.addLast(v);
        }
        return lista;
    }

    // ── edges() – O(m) ─────────────────────────
    public Iterable<Edge<E>> edges() {
        PositionList<Edge<E>> lista = new ListDEC<Edge<E>>();
        for (Edge<E> e : this.arcos) {
            lista.addLast(e);
        }
        return lista;
    }


    // ── incidentEdges(v) – O(deg(v)) ──────────────────────────────────────────
    public Iterable<Edge<E>> incidentEdges(Vertex<V> v) {
        PositionList<Edge<E>> lista = new ListDEC<Edge<E>>();
        Vertice<V,E> vert = checkVertex(v);
        for (Edge<E> e : vert.getAdyacentes()) {
            lista.addLast(e);
        }
        return lista;
    }
    
    // ── opposite(v,e) – O(1) ──────────────────
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        checkVertex(v);
        Arco<V, E> arc = checkEdge(e);
        if (arc.getV1().equals(v))
            return arc.getV2();
        if (arc.getV2().equals(v))
            return arc.getV1();
        throw new InvalidEdgeException("Arco invalido");
    }

    // ── endVertices(e) – O(1) ─────────────────
    public Vertex<V> [] endVertices(Edge<E> e) {
        Arco<V,E> arc = checkEdge(e);
        Vertice<V,E> [] endVertices = new Vertice [2];
        endVertices[0] = arc.getV1();
        endVertices[1] = arc.getV2();
        return endVertices;
    }

    // ── areAdjacent(v,w) – O(deg(v)) ───────────────
    public boolean areAdjacent(Vertex<V> v, Vertex<V> w) {
        Vertice<V,E> v1 = checkVertex(v);
        Vertice<V,E> v2 = checkVertex(w);
        for (Edge<E> e: v1.getAdyacentes()) {
            Arco<V,E> arc = checkEdge(e);
            if ((arc.getV1().equals(v1) && arc.getV2().equals(v2)) ||
                (arc.getV1().equals(v2) && arc.getV2().equals(v1)))
                return true;
        }
        return false;
    }

    // ── replace(v,x) – O(1) ───────────────────
    public V replace(Vertex<V> v, V x) {
        Vertice<V,E> v1 = checkVertex(v);
        V replaced = v1.element();
        v1.setRotulo(x);
        return replaced;
    }

    // ── replace(e,x) – O(1) ───────────────────
    public E replace(Edge<E> e, E x) {
        Arco<V,E> e1 = checkEdge(e);
        E replaced = e1.element();
        e1.setRotulo(x);
        return replaced;
    }

    // ── insertVertex(x) – O(1) ────────────────────────────────────────────────
    public Vertex<V> insertVertex(V x) {
        Vertice<V, E> v = new Vertice<V, E>(x);
        this.nodos.addLast(v);
        v.setPosicionEnNodos(this.nodos.last());
        return v;
    }

    // ── insertEdge(v,w,x) – O(1) ──────────────────────────────────────────────
    public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x) {
        // Obtengo los vértices v y w:
        Vertice<V, E> vv = checkVertex(v);
        Vertice<V, E> ww = checkVertex(w);

        Arco<V, E> arco = new Arco<V, E>(x, vv, ww);

        // Agrego el arco al final de la lista de adyacentes de v y anoto su posición:
        vv.getAdyacentes().addLast(arco);
        arco.setPosicionEnIv1(vv.getAdyacentes().last());

        // Agrego el arco al final de la lista de adyacentes de w y anoto su posición:
        ww.getAdyacentes().addLast(arco);
        arco.setPosicionEnIv2(ww.getAdyacentes().last());

        // Agrego el arco al final de la lista de arcos y le seteo su posición:
        this.arcos.addLast(arco);
        arco.setPosicionEnArcos(this.arcos.last());

        return arco;
    }

    // ── removeEdge(e) – O(1) ──────────────────────────────────────────────────
    public E removeEdge(Edge<E> e) {
        Arco<V, E> ee = checkEdge(e);

        // Recupero extremos del arco:
        Vertice<V, E> v1 = ee.getV1();
        Vertice<V, E> v2 = ee.getV2();

        // Elimino a e de la lista de adyacentes de v1:
        v1.getAdyacentes().remove(ee.getPosicionEnIv1());

        // Elimino a e de la lista de adyacentes de v2:
        v2.getAdyacentes().remove(ee.getPosicionEnIv2());

        // Elimino a e de la lista de arcos y retorno el rótulo del arco:
        Position<Arco<V, E>> pee = ee.getPosicionEnArcos();
        return this.arcos.remove(pee).element();
    }

    // ── removeVertex(v) – O(1) ──────────────────────────────────────────────────
    // Precondición: asume que v no tiene arcos adyacentes.
    public V removeVertex(Vertex<V> v) {
        Position<Vertice<V, E>> pos = (checkVertex(v)).getPosicionEnNodos();
        return this.nodos.remove(pos).element();
    }

    // ── checkVertex(v) – O(1) ──────────────────────────────────────────────────
    private Vertice<V,E> checkVertex(Vertex<V> v) {
        if (v == null || v.element() == null)
            throw new InvalidVertexException("Vertice Nulo");
        try {
            return (Vertice<V,E>) v;
        } catch (ClassCastException e) {
            throw new InvalidVertexException("Vertice Invalido");
        }
    }

    // ── checkEdge(e) – O(1) ──────────────────────────────────────────────────
    private Arco<V,E> checkEdge(Edge<E> e) {
        if (e == null || e.element() == null)
            throw new InvalidEdgeException("Arco Nulo");
        try {
            return (Arco<V,E>) e;
        } catch (ClassCastException er) {
            throw new InvalidEdgeException("Arco Invalido");
        }
    }







    private class Vertice<V, E> implements Vertex<V> {
        private V rotulo;
        private PositionList<Arco<V, E>> adyacentes;
        private Position<Vertice<V, E>> posicionEnNodos;

        public Vertice(V rotulo) {
            this.rotulo = rotulo;
            this.adyacentes = new ListDEC<Arco<V, E>>();
        }

        public V element() {
            return this.rotulo;
        }

        public void setRotulo(V nuevoRotulo) {
            this.rotulo = nuevoRotulo;
        }

        public PositionList<Arco<V, E>> getAdyacentes() {
            return this.adyacentes;
        }

        public void setPosicionEnNodos(Position<Vertice<V, E>> p) {
            this.posicionEnNodos = p;
        }

        public Position<Vertice<V, E>> getPosicionEnNodos() {
            return this.posicionEnNodos;
        }
    }




    private class Arco<V, E> implements Edge<E> {
        private E rotulo;
        private Vertice<V, E> v1, v2;
        private Position<Arco<V, E>> posicionEnArcos;
        private Position<Arco<V, E>> posicionEnIv1, posicionEnIv2;

        public Arco(E rotulo, Vertice<V, E> v1, Vertice<V, E> v2) {
            this.rotulo = rotulo;
            this.v1 = v1;
            this.v2 = v2;
        }

        public E element() {
            return this.rotulo;
        }

        public void setRotulo(E nuevoRotulo) {
            this.rotulo = nuevoRotulo;
        }

        public Vertice<V, E> getV1() {
            return this.v1;
        }

        public Vertice<V, E> getV2() {
            return this.v2;
        }

        public void setPosicionEnArcos(Position<Arco<V, E>> p) {
            this.posicionEnArcos = p;
        }

        public Position<Arco<V, E>> getPosicionEnArcos() {
            return this.posicionEnArcos;
        }

        public void setPosicionEnIv1(Position<Arco<V, E>> p) {
            this.posicionEnIv1 = p;
        }

        public Position<Arco<V, E>> getPosicionEnIv1() {
            return this.posicionEnIv1;
        }

        public void setPosicionEnIv2(Position<Arco<V, E>> p) {
            this.posicionEnIv2 = p;
        }

        public Position<Arco<V, E>> getPosicionEnIv2() {
            return this.posicionEnIv2;
        }
    }
}