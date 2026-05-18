package ar.edu.uns.cs.ed.tdas.tps.tp6;

import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;
import java.util.Iterator;

public class Arbol<E> implements Tree<E> {
	private TNode<E> root;
	private int size;

	public Arbol() {
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

	private void preOrden(TNode<E> nodo, PositionList<Position<E>> lista) {
		lista.addLast(nodo);
		for (TNode<E> n : nodo.getChildrens()) {
			this.preOrden(n, lista);
		} 
	}

	private void postOrden(TNode<E> nodo, PositionList<Position<E>> lista) {
		for (TNode<E> n : nodo.getChildrens()) {
			this.postOrden(n, lista);
		} 
		lista.addLast(nodo);
	}
	
	/**
	 * Devuelve una colección iterable de las posiciones de los nodos del árbol.
	 * @return Colección iterable de las posiciones de los nodos del árbol.
	 */
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new ListDEC<Position<E>>();
		if (!this.isEmpty()) { this.preOrden(this.root, lista); }
		return lista;
	}
	
	/**
	 * Reemplaza el elemento almacenado en la posición dada por el elemento pasado por parámetro. Devuelve el elemento reemplazado.
	 * @param v Posición de un nodo.
	 * @param e Elemento a reemplazar en la posición pasada por parámetro.
	 * @return Elemento reemplazado.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public E replace(Position<E> v, E e) {
		TNode<E> nodo = this.checkPosition(v);
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
		if (this.isEmpty())
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
		if (v == null)
			throw new InvalidPositionException("Posicion nula");
		if (v == this.root)
			throw new BoundaryViolationException("Root no tiene padre");
		return this.checkPosition(v).getFather();
	}
	
	/**
	 * Devuelve una colección iterable de los hijos del nodo correspondiente a una posición dada.
	 * @param v Posición de un nodo.
	 * @return Colección iterable de los hijos del nodo correspondiente a la posición pasada por parámetro.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public Iterable<Position<E>> children(Position<E> v) {
		TNode<E> nodo = this.checkPosition(v);
		PositionList<Position<E>> lista = new ListDEC<>();
		for (Position<E> p : nodo.getChildrens()) {
			lista.addLast(p);
		}
		return lista;
	}
	
	/**
	 * Consulta si una posición corresponde a un nodo interno.
	 * @param v Posición de un nodo.
	 * @return Verdadero si la posición pasada por parámetro corresponde a un nodo interno, falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public boolean isInternal(Position<E> v) {
		return !this.checkPosition(v).getChildrens().isEmpty();
	}
	
	/**
	 * Consulta si una posición dada corresponde a un nodo externo.
	 * @param v Posición de un nodo.
	 * @return Verdadero si la posición pasada por parámetro corresponde a un nodo externo, falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public boolean isExternal(Position<E> v) {
		return this.checkPosition(v).getChildrens().isEmpty();
	}
	
	/**
	 * Consulta si una posición dada corresponde a la raíz del árbol.
	 * @param v Posición de un nodo.
	 * @return Verdadero, si la posición pasada por parámetro corresponde a la raíz del árbol,falso en caso contrario.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	public boolean isRoot(Position<E> v) {
		return this.checkPosition(v) == this.root;
	}
	
	/**
	 * Crea un nodo con rótulo e como raíz del árbol.
	 * @param E Rótulo que se asignará a la raíz del árbol.
	 * @throws InvalidOperationException si el árbol ya tiene un nodo raíz.
	 */
	public void createRoot(E e) {
		if (this.root != null)
			throw new InvalidOperationException("El arbol ya tiene una Root");
		this.root = new TNode<E>(e, null);
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
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		
		TNode<E> nodo = this.checkPosition(p);
		TNode<E> nuevo = new TNode<E>(e, p);
		nodo.getChildrens().addFirst(nuevo);
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
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		
		TNode<E> nodo = this.checkPosition(p);
		TNode<E> nuevo = new TNode<E>(e, p);
		nodo.getChildrens().addLast(nuevo);
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
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");
		
		TNode<E> father = this.checkPosition(p);
		TNode<E> rightBrother = this.checkPosition(rb);
		if (rightBrother.getFather() != father)
			throw new InvalidPositionException("Right Brother no es hijo de Father");

		TNode<E> nuevo = new TNode<E>(e, father);

		for (Position<TNode<E>> position : father.getChildrens().positions()) {
            if (position.element() == rightBrother) {
				father.getChildrens().addBefore(position, nuevo);
                this.size++;
                return nuevo;
            }
        }
		throw new InvalidPositionException("(no hay flujo que permita llegar aca)");
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
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");

		TNode<E> father = this.checkPosition(p);
		TNode<E> leftBrother = this.checkPosition(lb);
		if (leftBrother.getFather() != father)
			throw new InvalidPositionException("Left Brother no es hijo de Father");

		TNode<E> nuevo = new TNode<E>(e, father);

		for (Position<TNode<E>> position : father.getChildrens().positions()) {
            if (position.element() == leftBrother) {
				father.getChildrens().addAfter(position, nuevo);
                this.size++;
                return nuevo;
            }
        }
		throw new InvalidPositionException("(no hay flujo que permita llegar aca)");
	}
	
	/**
	 * Elimina el nodo referenciado por una posición dada, si se trata de un nodo externo. 
	 * @param n Posición del nodo a eliminar.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida o no corresponde a un nodo externo, o el árbol está vacío.
	 */
	public void removeExternalNode (Position<E> p) {
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");

		TNode<E> nodo = this.checkPosition(p);
		if (!nodo.getChildrens().isEmpty())
			throw new InvalidPositionException("P no es nodo externo");

		if (nodo == this.root) {
			this.root = null;
		} else {
			PositionList<TNode<E>> childrens = this.checkPosition(nodo.getFather()).getChildrens();
			for (Position<TNode<E>> position : childrens.positions()) {
				if (position.element() == p) {
					childrens.remove(position);
					nodo.setElement(null);
				}
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
		if (this.isEmpty())
			throw new InvalidPositionException("Arbol vacio");

		TNode<E> nodo = this.checkPosition(p);

		if (nodo.getChildrens().isEmpty())
			throw new InvalidPositionException("P no es nodo interno");

		if (nodo == this.root) {

			// root con mas de 1 hijo
			if (nodo.getChildrens().size() > 1 )
				throw new InvalidPositionException("Root tiene mas de un hijo");

			// root con un solo hijo
			this.root = nodo.getChildrens().first().element();
			this.root.setFather(null);
			nodo.setElement(null);
			nodo.getChildrens().remove(nodo.getChildrens().first());

		} else {
			// agregar hijos de p a hijos de p.father, addBefore(p)
			// desreferenciar childrens de p
			TNode<E> fatherP = this.checkPosition(nodo.getFather());
			PositionList<TNode<E>> childrensFatherP = fatherP.getChildrens();

			Position<TNode<E>> posNodo = null;
			for (Position<TNode<E>> hijo : childrensFatherP.positions()) {
				if (hijo.element() == nodo) {
					posNodo = hijo;
					break;
				}
			}

			for (TNode<E> n : nodo.getChildrens()) {
				n.setFather(fatherP);
				childrensFatherP.addBefore(posNodo, n);
			}

			// desreferenciar a p de p.father
			childrensFatherP.remove(posNodo);
			nodo.setFather(null);
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
		if (this.checkPosition(p).getChildrens().isEmpty()) {
			this.removeExternalNode(p);
		} else {
			this.removeInternalNode(p);
		}
	}

	private TNode<E> checkPosition(Position<E> p) {
		try {
            if (p == null)
                throw new InvalidPositionException("Posicion nula");
            if (p.element() == null)
                throw new InvalidPositionException("p eliminada previamente");
            return (TNode<E>) p;
        } catch (InvalidPositionException e) {
            throw new InvalidPositionException("p no es un nodo de la lista");
        }
	}
}