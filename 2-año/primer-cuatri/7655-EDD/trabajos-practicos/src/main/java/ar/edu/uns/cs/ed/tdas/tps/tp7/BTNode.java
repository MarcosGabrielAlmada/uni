package ar.edu.uns.cs.ed.tdas.tps.tp7;

public class BTNode<E> implements BTPosition<E> {
	private E element;
	private BTPosition<E> parent, left, right;
	
	public BTNode(E e, BTPosition<E> p) {
		this.element = e;
		this.parent = p;
		this.left = null;
		this.right = null;
	}

	public E element() { return this.element; }
	public BTPosition<E> getParent() { return this.parent; }
	public BTPosition<E> getLeft() { return this.left; }
	public BTPosition<E> getRight() { return this.right; }
	
	public void setElement(E e) { this.element = e; }
	public void setParent(BTPosition<E> p) { this.parent = p; }
	public void setLeft(BTPosition<E> l) { this.left = l; }
	public void setRight(BTPosition<E> r) { this.right = r; }
}
