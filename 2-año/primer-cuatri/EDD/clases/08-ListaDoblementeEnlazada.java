package datos.tdalista;

public class ListaDoblementeEnlazadaMasClase8<E> extends ListaDoblementeEnlazada<E> {
	public ListaDoblementeEnlazada<E> clone() {
		return cloneAuxV3();
	}

	private ListaDoblementeEnlazada<E> cloneAuxV1() {
		ListaDoblementeEnlazada<E> resultado = new ListaDoblementeEnlazada<E>();
		for (E item : this) resultado.addLast(item);
		return resultado;
	}
	
	private ListaDoblementeEnlazada<E> cloneAuxV2() {
		ListaDoblementeEnlazada<E> resultado = new ListaDoblementeEnlazada<E>();
		Position<E> p = first(), ultima = last();
		while ( p != null ) {
			resultado.addLast(p.element());
			p = (p == ultima) ? null : next(p);
		}
		return resultado;
	}
	
	private ListaDoblementeEnlazada<E> cloneAuxV3() {
		ListaDoblementeEnlazada<E> resultado = new ListaDoblementeEnlazada<E>();
		DNode<E> p = header.getSiguiente();
		while ( p != trailer ) {
			resultado.addLast(p.element());
			p = p.getSiguiente();
		}
		return resultado;
	}
	
	public void ejercicio6(E item) {
		if (isEmpty()) return;
		DNode<E> p = header.getSiguiente();
		while (p != trailer) {
			if (p.getElemento().equals(item)) {
				DNode<E> anterior = p.getPrevio();
				DNode<E> siguiente = p.getSiguiente();
				anterior.setSiguiente(siguiente);
				siguiente.setPrevio(anterior);
				cantidadElementos--;
				p.setElemento(null);
				p = siguiente;
			} else {
				p = p.getSiguiente();
			}
		}
	}	
		
		
		public void ejercicio6bis(E item) {
			if (!isEmpty()) {
				DNode<E> p = header.getSiguiente();
				while (p != trailer) {
					if (!p.getElemento().equals(item)) {
						p = p.getSiguiente();
					} else {
						DNode<E> anterior = p.getPrevio();
						DNode<E> siguiente = p.getSiguiente();
						anterior.setSiguiente(siguiente);
						siguiente.setPrevio(anterior);
						cantidadElementos--;
						p.setElemento(null);
						p = siguiente;
					} 
				}
			}
		
		
	}
	
	public void ejercicio7(E item) {
		if (!isEmpty()) {
			DNode<E> p = header.getSiguiente();
			while (p != trailer) {
				if (p.element().equals(item) == false) {
					// addBefore(p, item);
					DNode<E> previo = p.getPrevio();
					DNode<E> nuevo = new DNode<E>(item);
					previo.setSiguiente(nuevo);
					nuevo.setPrevio(previo);
					nuevo.setSiguiente(p);
					p.setPrevio(nuevo);
					cantidadElementos++;
				}
				p = p.getSiguiente();
			}
		}
	}
	
	
}
