package ar.edu.uns.cs.ed.tdas.tps.tp6;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListaDEC;

public class TNodo<E> implements Position<E>{
	private E element;
	private Position<E> father;
	private ListaDEC<TNodo<E>> childrens;

	public TNodo(E elem, Position<E> father) {
		this.element = elem;
		this.father = father;
		this.childrens = new ListaDEC<TNodo<E>>();
	}

	public E element() {
		return this.element;
	}

	public Position<E> getFather() {
		return this.father;
	}

	public PositionList<TNodo<E>> getChildrens() {
		return this.childrens;
	}

	public void setElement(E elem) {
		this.element = elem;
	}

	public void setFather(Position<E> father) {
		this.father = father;
	}

	// public void setChildrens(PositionList<TNodo<E>> sons) {
	// 	this.childrens = sons;
	// }
}
