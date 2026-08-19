package ar.edu.uns.cs.ed.tdas.tps.tp7;

import ar.edu.uns.cs.ed.tdas.Position;

public interface BTPosition<E> extends Position<E> {
	public BTPosition<E> getParent();
	public BTPosition<E> getLeft();
	public BTPosition<E> getRight();
	
	public void setElement(E e);
	public void setParent(BTPosition<E> p);
	public void setLeft(BTPosition<E> l);
	public void setRight(BTPosition<E> r);
}
