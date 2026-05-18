package ar.edu.uns.cs.ed.tdas.tps.tp6;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;

public class TNode<E> implements Position<E>{
	private E element;
	private Position<E> father;
	private ListDEC<TNode<E>> childrens;

	public TNode(E elem, Position<E> father) {
		this.element = elem;
		this.father = father;
		this.childrens = new ListDEC<TNode<E>>();
	}

	public E element() {
		return this.element;
	}

	public Position<E> getFather() {
		return this.father;
	}

	public PositionList<TNode<E>> getChildrens() {
		return this.childrens;
	}

	public void setElement(E elem) {
		this.element = elem;
	}

	public void setFather(Position<E> father) {
		this.father = father;
	}
}
