package ar.edu.uns.cs.ed.tdas.tps.tp7;

import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;
import java.util.Iterator;

public class ArbolBinario<E> implements BinaryTree<E> {
	private BTPosition<E> root;
	private int size;

	public ArbolBinario() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * Consulta la cantidad de nodos en el árbol.
	 * @return Cantidad de nodos en el árbol.
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Consulta si el árbol está vacío.
	 * @return Verdadero si el árbol está vacío, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * Devuelve un iterador de los elementos almacenados en el árbol en preorden.
	 * @return Iterador de los elementos almacenados en el árbol.
	 */
	public Iterator<E> iterator() {
		PositionList<E> lista = new ListDEC<E>();
		for (Position<E> p : this.positions()) {
			lista.addLast(p.element());
		}
		return lista.iterator();
	}
	
	/**
	 * Devuelve una colección iterable de las posiciones de los nodos del árbol.
	 * @return Colección iterable de las posiciones de los nodos del árbol.
	 */
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new ListDEC<>();
		
		if(!this.isEmpty()) {
			this.preOrden(this.checkPosition(this.root), lista);
		}
		return lista;
	}

	private void preOrden(BTPosition<E> nodo, PositionList<Position<E>> lista) {
		lista.addLast(nodo);
		if (this.hasLeft(nodo)) { this.preOrden(nodo.getLeft(), lista); }
		if (this.hasRight(nodo)) { this.preOrden(nodo.getRight(), lista); }
	}

	private void inOrden(BTPosition<E> nodo, PositionList<Position<E>> lista) {
		if (this.hasLeft(nodo)) { this.inOrden(nodo.getLeft(), lista); }
		lista.addLast(nodo);
		if (this.hasRight(nodo)) { this.inOrden(nodo.getRight(), lista); }
	}

	private void postOrden(BTPosition<E> nodo, PositionList<Position<E>> lista) {
		if (this.hasLeft(nodo)) { this.postOrden(nodo.getLeft(), lista); }
		if (this.hasRight(nodo)) { this.postOrden(nodo.getRight(), lista); }
		lista.addLast(nodo);
	}
	
	/**
	 * Reemplaza el elemento almacenado en la posición dada por el elemento pasado por parámetro. Devuelve el elemento reemplazado.
	 * @param v Posición de un nodo.
	 * @param e Elemento a reemplazar en la posición pasada por parámetro.
	 * @return Elemento reemplazado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public E replace(Position<E> v, E e) {
		BTPosition<E> nodo = this.checkPosition(v);
		E aux = nodo.element();
		nodo.setElement(e);
		return aux;
	}
	
	/**
	 * Devuelve la posición de la raíz del árbol.
	 * @return Posición de la raíz del árbol.
	 * @throws EmptyTreeException si el árbol está vacío.
	 */
	public Position<E> root() {
		if (this.root == null)
			throw new EmptyTreeException("Arbol vacio");
		return this.root;
	}
	
	/**
	 * Devuelve la posición del nodo padre del nodo correspondiente a una posición dada.
	 * @param v Posición de un nodo.
	 * @return Posición del nodo padre del nodo correspondiente a la posición dada.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 * @throws BoundaryViolationException si la posición pasada por parámetro corresponde a la raíz del árbol.
	 */
	public Position<E> parent(Position<E> v) {
		BTPosition<E> nodo = this.checkPosition(v);
		if (nodo == this.root)
			throw new BoundaryViolationException("Root no tiene Parent");
		return nodo.getParent();
	}
	
	/**
	 * Devuelve una colección iterable de los hijos del nodo correspondiente a una posición dada.
	 * @param v Posición de un nodo.
	 * @return Colección iterable de los hijos del nodo correspondiente a la posición pasada por parámetro.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public Iterable<Position<E>> children(Position<E> v) {
		BTPosition<E> nodo = this.checkPosition(v);
		PositionList<Position<E>> lista = new ListDEC<Position<E>>();

		if (this.hasLeft(v)) { lista.addLast(nodo.getLeft()); }
		if (this.hasRight(v)) { lista.addLast(nodo.getRight()); }

		return lista;
	}
	
	/**
	 * Consulta si una posición corresponde a un nodo interno.
	 * @param v Posición de un nodo.
	 * @return Verdadero si la posición pasada por parámetro corresponde a un nodo interno, falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public boolean isInternal(Position<E> v) {
		this.checkPosition(v);
		return this.hasLeft(v) || this.hasRight(v);
	}
	
	/**
	 * Consulta si una posición dada corresponde a un nodo externo.
	 * @param v Posición de un nodo.
	 * @return Verdadero si la posición pasada por parámetro corresponde a un nodo externo, falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public boolean isExternal(Position<E> v) {
		this.checkPosition(v);
		return !this.hasLeft(v) && !this.hasRight(v);
	}
	
	/**
	 * Consulta si una posición dada corresponde a la raíz del árbol.
	 * @param v Posición de un nodo.
	 * @return Verdadero, si la posición pasada por parámetro corresponde a la raíz del árbol,falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public boolean isRoot(Position<E> v) {
		this.checkPosition(v);
		return this.root == v;
	}
	
	/**
	 * Crea un nodo con rótulo e como raíz del árbol.
	 * @param E Rótulo que se asignará a la raíz del árbol.
	 * @throws InvalidOperationException si el árbol ya tiene un nodo raíz.
	 */
	public void createRoot(E e) {
		if (this.root != null)
			throw new InvalidOperationException("Root ya existe");
		this.root = new BTNode<E>(e, null);
		this.size++;
	}
	
	/**
	 * Agrega un nodo con rótulo e como primer hijo de un nodo dado.
	 * @param e Rótulo del nuevo nodo.
	 * @param padre Posición del nodo padre.
	 * @return La posición del nuevo nodo creado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío.
	 */
	public Position<E> addFirstChild(Position<E> p, E e) {
		if(this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		if(this.hasLeft(p))
			throw new InvalidPositionException("P ya tiene FirstChild");

		BTPosition<E> nodo = this.checkPosition(p);
		BTPosition<E> nuevo = new BTNode<E>(e, nodo);
		nodo.setLeft(nuevo);
		this.size++;
		return nuevo;
	}
	
	/**
	 * Agrega un nodo con rótulo e como último hijo de un nodo dado.
	 * @param e Rótulo del nuevo nodo.
	 * @param p Posición del nodo padre.
	 * @return La posición del nuevo nodo creado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío.
	 */
	public Position<E> addLastChild(Position<E> p, E e) {
		if(this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		if(this.hasRight(p))
			throw new InvalidPositionException("P ya tiene LastChild");

		BTPosition<E> nodo = this.checkPosition(p);
		BTPosition<E> nuevo = new BTNode<E>(e, nodo);
		nodo.setRight(nuevo);
		this.size++;
		return nuevo;
	}
	
	/**
	 * Agrega un nodo con rótulo e como hijo de un nodo padre dado. El nuevo nodo se agregará delante de otro nodo también dado.
	 * @param e Rótulo del nuevo nodo.
	 * @param p Posición del nodo padre.
	 * @param rb Posición del nodo que será el hermano derecho del nuevo nodo.
	 * @return La posición del nuevo nodo creado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida, o el árbol está vacío, o la posición rb no corresponde a un nodo hijo del nodo referenciado por p.
	 */
	public Position<E> addBefore(Position<E> p, Position<E> rb, E e) {
		if(this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");

		BTPosition<E> nodo = this.checkPosition(p);
		BTPosition<E> rightBrother = this.checkPosition(rb);
		BTPosition<E> nuevo = new BTNode<E>(e, nodo);

		if (nodo.getLeft() == rightBrother) {
			nodo.setRight(rightBrother);
			nodo.setLeft(nuevo);
			this.size++;
		}
		
		if (nodo.getRight() == rightBrother) {
			nodo.setLeft(nuevo);
			this.size++;
		}

		throw new InvalidPositionException("RightBrother no es hijo de P");
	}

	/**
	 * Agrega un nodo con rótulo e como hijo de un nodo padre dado. El nuevo nodo se agregará a continuación de otro nodo también dado.
	 * @param e Rótulo del nuevo nodo.
	 * @param p Posición del nodo padre.
	 * @param lb Posición del nodo que será el hermano izquierdo del nuevo nodo.
	 * @return La posición del nuevo nodo creado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida, o el árbol está vacío, o la posición lb no corresponde a un nodo hijo del nodo referenciado por p.
	 */
	public Position<E> addAfter (Position<E> p, Position<E> lb, E e) {
		if(this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");

		BTPosition<E> nodo = this.checkPosition(p);
		BTPosition<E> leftBrother = this.checkPosition(lb);
		BTPosition<E> nuevo = new BTNode<E>(e, nodo);

		if (nodo.getLeft() == leftBrother) {
			nodo.setRight(nuevo);
			this.size++;
		}
		
		if (nodo.getRight() == leftBrother) {
			nodo.setLeft(leftBrother);
			nodo.setRight(nuevo);
			this.size++;
		}

		throw new InvalidPositionException("LeftBrother no es hijo de P");
	}
	
	/**
	 * Elimina el nodo referenciado por una posición dada, si se trata de un nodo externo. 
	 * @param n Posición del nodo a eliminar.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o no corresponde a un nodo externo, o el árbol está vacío.
	 */
	public void removeExternalNode (Position<E> p) {
		if(this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");

		BTPosition<E> nodo = this.checkPosition(p);

		if (this.hasLeft(nodo) || this.hasRight(nodo))
			throw new InvalidPositionException("P no es ExternalNode");

		if (nodo == this.root) {
			this.root = null;
		} else {
			BTPosition<E> parent = nodo.getParent();
			if (parent.getLeft() == nodo) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		this.size--;
	}
	
	/**
	 * Elimina el nodo referenciado por una posición dada, si se trata de un nodo interno. Los hijos del nodo eliminado lo reemplazan en el mismo orden en el que aparecen. 
	 * Si el nodo a eliminar es la raíz del árbol, únicamente podrá ser eliminado si tiene un solo hijo, el cual lo reemplazará.
	 * @param n Posición del nodo a eliminar.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o no corresponde a un nodo interno o corresponde a la raíz (con más de un hijo), o el árbol está vacío.
	 */
	public void removeInternalNode (Position<E> p) {
		if(this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		
		BTPosition<E> nodo = this.checkPosition(p);

		if (nodo == this.root) { // es la raiz
			if (this.hasLeft(nodo) && this.hasRight(nodo)) // tiene 2 hijos
				throw new InvalidPositionException("P es Root, Root tiene mas de 2 hijos");

			BTPosition<E> hijo = this.hasLeft(nodo) ? nodo.getLeft() : nodo.getRight();
			if (hijo != null) { // tiene 1 hijo
				hijo.setParent(null);
				this.root = hijo;
			} else { // no tiene hijos
				throw new InvalidPositionException("P es Root, Root no tiene hijos");
			}

		} else { // no es la raiz
			if (!this.hasLeft(nodo) && !this.hasRight(nodo))
				throw new InvalidPositionException("P no es InternalNode");

			BTPosition<E> parent = nodo.getParent();

			
			if (this.hasLeft(parent) && this.hasRight(parent)) { // padre con 2 hijos
				if (this.hasLeft(nodo) && this.hasRight(nodo))  // nodo con 2 hijos
					throw new InvalidPositionException("P tiene mas de 2 hijos, P.parent tiene mas de 2 hijos");

				if (parent.getLeft() == nodo) { // nodo con 1 hijo
					if (this.hasLeft(nodo)) {
						parent.setLeft(nodo.getLeft());
						nodo.getLeft().setParent(parent);
					} else {
						parent.setLeft(nodo.getRight());
						nodo.getRight().setParent(parent);
					}
				} else {
					if (this.hasLeft(nodo)) {
						parent.setRight(nodo.getLeft());
						nodo.getLeft().setParent(parent);
					} else {
						parent.setRight(nodo.getRight());
						nodo.getRight().setParent(parent);
					}
				}
			} else { // padre con 1 hijo
				if (this.hasLeft(parent)) {
					parent.setLeft(nodo.getLeft());
					parent.setRight(nodo.getRight());
				}
				if (this.hasLeft(nodo)) {
					nodo.getLeft().setParent(parent);
				}
				if (this.hasRight(nodo)) {
					nodo.getRight().setParent(parent);
				}
			}
		}
		this.size--;
	}
	
	/**
	 * Elimina el nodo referenciado por una posición dada. Si se trata de un nodo interno, los hijos del nodo eliminado lo reemplazan en el mismo orden en el que aparecen. 
	 * Si el nodo a eliminar es la raíz del árbol, únicamente podrá ser eliminado si tiene un solo hijo, el cual lo reemplazará.
	 * @param n Posición del nodo a eliminar.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o corresponde a la raíz (con más de un hijo), o el árbol está vacío.
	 */
	public void removeNode (Position<E> p) {
		BTPosition<E> nodo = this.checkPosition(p);
		if (this.hasLeft(nodo) || this.hasRight(nodo)) {
			this.removeInternalNode(p); // este decrementa size
		} else {
			this.removeExternalNode(p); // este decrementa size
		}
	}

	/**
	 * Devuelve la posición del hijo izquierdo de v.
	 * @param v Posición de un nodo.
	 * @return Posición del hijo izquierdo de v.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 * @throws BoundaryViolationException si v no tiene hijo izquierdo.
	 */
	public Position<E> left(Position<E> v) {
		BTPosition<E> nodo = this.checkPosition(v);
		if (!this.hasLeft(nodo))
			throw new BoundaryViolationException("V no tiene Left");
		return nodo.getLeft();
	}
	
	/**
	 * Devuelve la posición del hijo derecho de v.
	 * @param v Posición de un nodo.
	 * @return Posición del hijo derecho de v.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 * @throws BoundaryViolationException si v no tiene hijo derecho.
	 */
	public Position<E> right(Position<E> v) {
		BTPosition<E> nodo = this.checkPosition(v);
		if (!this.hasRight(nodo))
			throw new BoundaryViolationException("V no tiene Right");
		return nodo.getRight();
	}

	/**
	 * Testea si v tiene un hijo izquierdo.
	 * @param v Posición de un nodo.
	 * @return Verdadero si v tiene un hijo izquierdo y falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.	
	 */
	public boolean hasLeft(Position<E> v) {
		BTPosition<E> nodo = this.checkPosition(v);
		return nodo.getLeft() != null;
	}
	
	
	/**
	 * Testea si v tiene un hijo derecho.
	 * @param v Posición de un nodo.
	 * @return Verdadero si v tiene un hijo derecho y falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.	
	 */
	public boolean hasRight(Position<E> v) {
		BTPosition<E> nodo = this.checkPosition(v);
		return nodo.getRight() != null;
	}

	/**
	 * Agrega un nodo con rótulo r como hijo izquierdo de un nodo dado.
	 * @param r Rótulo del nuevo nodo.
	 * @param v Posición del nodo padre.
	 * @return La posición del nuevo nodo creado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío.
	 * @throws InvalidOperationException si v ya tiene un hijo izquierdo.
	 */
	public Position<E> addLeft(Position<E> v, E r) {
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		BTPosition<E> nodo = this.checkPosition(v);

		if (this.hasLeft(nodo))
			throw new InvalidOperationException("V ya tiene Left");

		BTPosition<E> nuevo = new BTNode<E>(r, nodo);
		nodo.setLeft(nuevo);
		this.size++;
		return nuevo;
	}
	
	/**
	 * Agrega un nodo con rótulo r como hijo derecho de un nodo dado.
	 * @param r Rótulo del nuevo nodo.
	 * @param v Posición del nodo padre.
	 * @return La posición del nuevo nodo creado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío.
	 * @throws InvalidOperationException si v ya tiene un hijo derecho.
	 */
	public Position<E> addRight(Position<E> v, E r) {
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		BTPosition<E> nodo = this.checkPosition(v);

		if (this.hasRight(nodo))
			throw new InvalidOperationException("V ya tiene Right");

		BTPosition<E> nuevo = new BTNode<E>(r, nodo);
		nodo.setRight(nuevo);
		this.size++;
		return nuevo;
	}

	/**
	 * Inserta a los árboles T1 y T2 como subárboles hijos de la hoja v (izquierdo y derecho respectivamente).
	 * @param v Posición de una hoja del árbol.
	 * @param T1 Árbol binario a insertar como hijo izquierdo de v.
	 * @param T2 Árbol binario a insertar como hijo derecho de v. 
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o el árbol está vacío, o v no corresponde a una hoja.
	 */
	public void attach(Position<E> r, BinaryTree<E> T1, BinaryTree<E> T2) {
		BTPosition<E> nodo = this.checkPosition(r);
		if (this.isInternal(nodo))
			throw new InvalidPositionException("R es Internal");

		if (!T1.isEmpty()) {
			BTPosition<E> root1 = this.checkPosition(T1.root());
			nodo.setLeft(root1);
			root1.setParent(nodo);
		}
		if (!T2.isEmpty()) {
			BTPosition<E> root2 = this.checkPosition(T2.root());
			nodo.setRight(root2);
			root2.setParent(nodo);
		}
		this.size += T1.size() + T2.size();
	}

	
	private BTNode<E> checkPosition(Position<E> p) {
		try {
            if (p == null)
                throw new InvalidPositionException("Posicion nula");
            if (p.element() == null)
                throw new InvalidPositionException("p eliminada previamente");
            return (BTNode<E>) p;
        } catch (InvalidPositionException e) {
            throw new InvalidPositionException("p no es un nodo de la lista");
        }
	}
}
