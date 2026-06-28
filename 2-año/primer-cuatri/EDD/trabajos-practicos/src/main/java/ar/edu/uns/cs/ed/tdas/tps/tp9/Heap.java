package ar.edu.uns.cs.ed.tdas.tps.tp9;

import java.util.Comparator;
import ar.edu.uns.cs.ed.tdas.tdacolaconprioridad.PriorityQueue;
import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tps.tp5.Entrada;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyPriorityQueueException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;


public class Heap<K, V> implements PriorityQueue<K, V> {
	protected Entrada<K, V>[] elems;
	protected Comparator<K> comp;
	protected int size;

	@SuppressWarnings("unchecked") // TODO - ???
	public Heap(int maxElems, Comparator<K> comp) {
		this.elems = (Entrada<K, V>[]) new Entrada[maxElems];
		this.comp = comp;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if (this.isEmpty())
			throw new EmptyPriorityQueueException();
		return this.elems[1];
	}

	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		Entrada<K, V> entrada = new Entrada<K, V>(key, value);
		this.elems[++this.size] = entrada;
		int i = this.size;
		boolean seguir = true;
		while (i > 1 && seguir) {
			Entrada<K, V> elemActual = this.elems[i];
			Entrada<K, V> elemPadre = this.elems[i / 2];
			if (this.comp.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				Entrada<K, V> aux = this.elems[i];
				this.elems[i] = this.elems[i / 2];
				this.elems[i / 2] = aux;
				i /= 2;
			} else {
				seguir = false;
			}
		}
		return entrada;
	}

	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		Entry<K, V> entrada = this.min();
		if (this.size == 1) {
			this.elems[1] = null;
			this.size = 0;
			return entrada;
		} else {
			this.elems[1] = this.elems[this.size];
			this.elems[this.size] = null;
			this.size--;
			int i = 1;
			boolean seguir = true;
			while (seguir) {
				int hi = i * 2;
				int hd = i * 2 + 1;
				boolean tieneHijoIzquierdo = hi <= this.size();
				boolean tieneHijoDerecho = hd <= this.size();
				if (!tieneHijoIzquierdo) {
					seguir = false;
				} else {
					int m;
					if (tieneHijoDerecho) {
						if (this.comp.compare(this.elems[hi].getKey(), this.elems[hd].getKey()) < 0)
							m = hi;
						else
							m = hd;
					} else {
						m = hi;
					}
					if (this.comp.compare(this.elems[i].getKey(), this.elems[m].getKey()) > 0) {
						Entrada<K, V> aux = this.elems[i];
						this.elems[i] = this.elems[m];
						this.elems[m] = aux;
						i = m;
					} else {
						seguir = false;
					}
				}
			}
			return entrada;
		}
	}
}