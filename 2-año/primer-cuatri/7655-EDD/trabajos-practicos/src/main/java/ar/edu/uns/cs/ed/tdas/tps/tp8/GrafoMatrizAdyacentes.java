package ar.edu.uns.cs.ed.tdas.tps.tp8;

import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEdgeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidVertexException;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;

public class GrafoMatrizAdyacentes<V, E> implements Graph<V, E> {

    protected PositionList<Vertex<V>> nodos;
    protected PositionList<Edge<E>> arcos;
	protected Edge<E> [][] matriz;
	protected int cantidadVertices;

	public GrafoListaAdyacentes(int n) {
		this.nodos = new ListDEC<Vertex<V>>();
		this.arcos = new ListDEC<Edge<E>>();
		this.matriz = (Edge<E> [][]) new Arco[n][n];
		this.cantidadVertices = n;

		for(int i=0; i<n; i++ )
			for(int j=0; j<n; j++ )
				matriz[i][j] = null;
	}

		/**
	 * Devuelve una colección iterable de vértices.
	 * @return Una colección iterable de vértices.
	 */
	public Iterable<Vertex<V>> vertices() {
		PositionList<Vertex<V>> lista = new ListDEC<Vertex<V>>();
		for (Vertex<V> v : this.nodos){
			lista.addLast(v);
		}
		return lista;
	}
	
	/**
	 * Devuelve una colección iterable de arcos.
	 * @return Una colección iterable de arcos.
	 */
	public Iterable<Edge<E>> edges() {
		PositionList<Edge<E>> lista = new ListDEC<Edge<E>>();
		for (Edge<E> v : this.arcos){
			lista.addLast(v);
		}
		return lista;
	}
	
	/**
	 * Devuelve una colección iterable de arcos incidentes a un vértice v.
	 * @param v Un vértice.
	 * @return Una colección iterable de arcos incidentes a un vértice v.
	 * @throws InvalidVertexException si el vértice es inválido.
	 */
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) {
		checkVertex(v);
		PositionList<Edge<E>> lista = new ListDEC<Edge<E>>();
		Arco<V,E> e;
		for (int i = 0; i < this.cantidadVertices; i++){
			e = checkEdge(this.matriz[this.cantidadVertices][i]);
			if (e != null) {
				lista.addLast(e);
			}
		}
		return lista;
	}
	
	
	/**
	 * Devuelve el vértice opuesto a un Arco E y un vértice V.
	 * @param v Un vértice
	 * @param e Un arco
	 * @return El vértice opuesto a un Arco E y un vértice V.
	 * @throws InvalidVertexException si el vértice es inválido.
	 * @throws InvalidEdgeException si el arco es inválido.
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        checkVertex(v);
        Arco<V, E> arc = checkEdge(e);
        if (arc.getV1().equals(v))
            return arc.getV2();
        if (arc.getV2().equals(v))
            return arc.getV1();
        throw new InvalidEdgeException("Arco invalido");
	}
	
	/**
	 * Devuelve un Arreglo de 2 elementos con lo vértices extremos de un Arco e.
	 * @param  e Un arco
	 * @return Un Arreglo de 2 elementos con los extremos de un Arco e.
	 * @throws InvalidEdgeException si el arco es inválido.
	 */
	public Vertex<V> [] endVertices(Edge<E> e) {
        Arco<V,E> arc = checkEdge(e);
        Vertice<V,E> [] endVertices = new Vertice [2];
        endVertices[0] = arc.getV1();
        endVertices[1] = arc.getV2();
        return endVertices;
	}
	
	/**
	 * Devuelve verdadero si el vértice w es adyacente al vértice v.
	 * @param v Un vértice
	 * @param w Un vértice
	 * @return Verdadero si el vértice w es adyacente al vértice v, falso en caso contrario.
	 * @throws InvalidVertexException si uno de los vértices es inválido.
	 */
	public boolean areAdjacent(Vertex<V> v,Vertex<V> w) {
		Vertice<V,E> vv = checkVertex(v);
		Vertice<V,E> ww = checkVertex(w);

		Arco<V,E> e = checkEdge(this.matriz[vv.getIndice()][ww.getIndice()]);
		if ((e.getV1())
	}
	
	/**
	 * Reemplaza el rótulo de v por un rótulo x.
	 * @param v Un vértice
	 * @param x Rótulo
	 * @return El rótulo anterior del vértice v al reemplazarlo por un rótulo x.
	 * @throws InvalidVertexException si el vértice es inválido.
	 */
	public V replace(Vertex<V> v, V x) {

	}

	/**
	 * Reemplaza el rótulo de e por un rótulo x.
	 * @param e Un arco
	 * @param x Rótulo
	 * @return El rótulo anterior del arco e al reemplazarlo por un rótulo x.
	 * @throws InvalidEdgeException si el arco es inválido.
	 */
	public E replace(Edge<E> e, E x) {

	}
	
	/**
	 * Inserta un nuevo vértice con rótulo x.
	 * @param x rótulo del nuevo vértice
	 * @return Un nuevo vértice insertado.
	 */
	public Vertex<V> insertVertex(V x) {

	}
	
	/**
	 * Inserta un nuevo arco con rótulo e, con vértices extremos v y w.
	 * @param v Un vértice
	 * @param w Un vértice
	 * @param e rótulo del nuevo arco.
	 * @return Un nuevo arco.
	 * @throws InvalidVertexException si uno de los vértices es inválido.
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) {

	}
	
	/**
	 * Remueve un vértice V y retorna su rótulo.
	 * @param v Un vértice
	 * @return rótulo de V.
	 * @throws InvalidVertexException si el vértice es inválido.
	 */
	public V removeVertex(Vertex<V> v) {

	}
	
	/**
	 * Remueve un arco e y retorna su rótulo.
	 * @param e Un arco
 	 * @return rótulo de E.
	 * @throws InvalidEdgeException si el arco es inválido.
	 */
	public E removeEdge(Edge<E> e) {

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
		private int indice;
        private PositionList<Arco<V, E>> adyacentes;
        private Position<Vertice<V, E>> posicionEnNodos;

        public Vertice(V rotulo, int indice) {
            this.rotulo = rotulo;
            this.indice = indice;
            this.adyacentes = new ListDEC<Arco<V, E>>();
        }

        public V element() {
            return this.rotulo;
        }

        public void setRotulo(V nuevoRotulo) {
            this.rotulo = nuevoRotulo;
        }

        public int getIndice() {
            return this.indice;
        }

        public void setIndice(int nuevoIndice) {
            this.indice = nuevoIndice;
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
