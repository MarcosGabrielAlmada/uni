package ar.edu.uns.cs.ed.tdas.tps.tp10;

import java.util.Comparator;

public class ConjuntoABB<E extends Comparable<E>> {
	protected NodoABB<E> raiz;
	protected int size;
	Comparator<E> comp;

	public ConjuntoABB(Comparator<E> comp) {
		this.raiz = new NodoABB<E>(null, null);
		this.size = 0;
		this.comp = comp;
	}

	public boolean member(E x) {
		return this.buscar(x).getRotulo() != null;
	}

	private NodoABB<E> buscar(E x) {
		return this.buscarAux(x, this.raiz);
	}

	private NodoABB<E> buscarAux(E x, NodoABB<E> p) {
		if (p.getRotulo() == null) return p;
		else {
			int c = this.comp.compare(x, p.getRotulo());
			if (c == 0) return p;
			else if (c < 0) return this.buscarAux(x, p.getIzq());
			else return this.buscarAux(x, p.getDer());
		}
	}

	public void insert(E x) {
		NodoABB<E> p = this.buscar(x);
		if (p.getRotulo() == null) {
			p.setRotulo(x);
			p.setIzq(new NodoABB<E>(null, p));
			p.setDer(new NodoABB<E>(null, p));
			this.size++;
		}
	}

	public void eliminar(E x) throws SetException {
		NodoABB<E> p = this.buscar(x);
		if (p.getRotulo() != null) {
			this.eliminarAux(p);
			this.size--;
		} else throw new SetException("eliminar: No pude eliminar");
	}

	private boolean isExternal(NodoABB<E> p) {
		return p.getIzq().getRotulo() == null &&
			   p.getDer().getRotulo() == null;
	}

	private boolean soloTieneHijoIzquierdo(NodoABB<E> p) {
		return p.getIzq().getRotulo() != null &&
			   p.getDer().getRotulo() == null;
	}

	private boolean soloTieneHijoDerecho(NodoABB<E> p) {
		return p.getDer().getRotulo() != null &&
			   p.getIzq().getRotulo() == null;
	}

	private void eliminarAux(NodoABB<E> p) {
		if (this.isExternal(p)) {
			p.setRotulo(null);
			p.setIzq(null);
			p.setDer(null);
		} else {
			if (p == this.raiz) {
				// TODO El PDF indica "Completar con casos 2, 3 y 4" pero no provee la implementación.
			} else if (this.soloTieneHijoIzquierdo(p)) {
				if (p.getPadre().getIzq() == p)
					p.getPadre().setIzq(p.getIzq());
				else
					p.getPadre().setDer(p.getIzq());
				p.getIzq().setPadre(p.getPadre());
			} else if (this.soloTieneHijoDerecho(p)) {
				if (p.getPadre().getIzq() == p)
					p.getPadre().setIzq(p.getDer());
				else
					p.getPadre().setDer(p.getDer());
				p.getDer().setPadre(p.getPadre());
			} else {
				p.setRotulo(this.eliminarMinimo(p.getDer()));
			}
		}
	}

	private E eliminarMinimo(NodoABB<E> p) {
		if (p.getIzq().getRotulo() == null) {
			E aRetornar = p.getRotulo();
			if (p.getDer().getRotulo() == null) {
				p.setRotulo(null);
				p.setIzq(null);
				p.setDer(null);
			} else {
				p.getPadre().setDer(p.getDer());
				p.getDer().setPadre(p.getPadre());
			}
			return aRetornar;
		} else {
			return this.eliminarMinimo(p.getIzq());
		}
	}

	public String toString() {
		return this.inorder(this.raiz);
	}

	private String inorder(NodoABB<E> p) {
		if (p.getRotulo() != null) {
			return "(" + this.inorder(p.getIzq())
					   + p.getRotulo()
					   + this.inorder(p.getDer()) + ")";
		} else return "";
	}
}