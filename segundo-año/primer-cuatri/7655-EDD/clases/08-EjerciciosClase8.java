/**
 * 
 */
package datos.tdalista;

import java.util.Iterator;
/**
 * @author sgomez
 *
 */
public class EjerciciosClase8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EjerciciosClase8 app = new EjerciciosClase8();
		app.run();
	}
	
	public void run() {
		PositionList<String> lista1 = new ListaDoblementeEnlazada<String>();
		lista1.addLast("sergio");
		lista1.addLast("martin");
		lista1.addLast("matias");
		
		PositionList<String> lista2 = new ListaDoblementeEnlazada<String>();
		lista2.addLast("carlos");  // Probar sacando primero, luego ultimo, luego uno del medio.
		lista2.addLast("sergio");
		lista2.addLast("martin");
		lista2.addLast("matias");
		lista2.addLast("marta");
		System.out.println("Incluida(l1,l2):" + estaIncluida(lista1, lista2));
		
		
		ListaDoblementeEnlazadaMasClase8<String> ldd8 = new ListaDoblementeEnlazadaMasClase8<>();
		ldd8.addLast("Pedro");
		ldd8.addLast("Pablo");
		ldd8.addLast("Maria");
		PositionList<String> otraLDD = ldd8.clone();
		System.out.println("Lista clonada: " + otraLDD);
		
		System.out.println("\nLdd8 antes de hacer nada: " + ldd8);
		ldd8.ejercicio6("Pedro");
		System.out.println("lld8 luego de eliminar a Pedro: " + ldd8);
		ldd8.ejercicio6("Maria");
		System.out.println("lld8 luego de eliminar a Maria: " + ldd8);
		ldd8.ejercicio6("Pablo");
		System.out.println("lld8 luego de eliminar a Pablo: " + ldd8);
		
		System.out.println("\nTest de eliminar con elementos repetidos:");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("2");
		ldd8.addLast("2");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("3");
		ldd8.addLast("3");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		ldd8.addLast("1");
		System.out.println("Ldd8 antes de hacer nada: " + ldd8);
		ldd8.ejercicio6("1");
		System.out.println("lld8 luego de eliminar a 1: " + ldd8);
		
		System.out.println("\nPrueba de ejercicio8:");
		ListaDoblementeEnlazadaMasClase8<Integer> lista = new ListaDoblementeEnlazadaMasClase8<>();
		lista.addLast(3);
		lista.addLast(4);
		lista.addLast(5);
		lista.addLast(6);
		lista.addLast(3);
		lista.addLast(3);
		lista.addLast(3);
		lista.addLast(4);
		lista.addLast(5);
		lista.addLast(6);
		lista.addLast(3);
		System.out.println("Lista antes de invocar  : " +  lista);
		lista.ejercicio7(3);
		System.out.println("Lista despues de invocar: " +  lista);
	}
	
	public <E> int ejercicio1(E elemento, PositionList<E> lista) {
		return cantidadApariciones(elemento, lista);
	}
	
	public <E> int cantidadApariciones(E elemento, PositionList<E> lista) {
		int contador = 0;
		if ( !lista.isEmpty() ) {
			Position<E> p = lista.first();
			while ( p != lista.last() ) {
				if (p.element().equals(elemento)) contador++;
				p = lista.next(p);
			}
			if (p.element().equals(elemento)) contador++;
		}
		return contador;
	}
	
	public <E> int cantidadApariciones(E elemento, PositionList<E> lista) {
		int contador = 0;
		if ( !lista.isEmpty() ) {
			Position<E> p = lista.first();
			while ( p != lista.last() ) {
				E elemento_lista = p.element();
				if (elemento_lista.equals(elemento)) contador++;
				p = lista.next(p);
			}
			if (p.element().equals(elemento)) contador++;
		}
		return contador;
	}
	
	
	public <E> int cantidadAparicionesBis(E elemento, PositionList<E> lista) {
		int contador = 0;
		if (lista.isEmpty() == false) {
			Position<E> ultima = lista.last();
			Position<E> p = lista.first();
			while ( p != null ) {
				if (p.element().equals(elemento)) contador++;
				// p = p != lista.last() ? lista.next(p) : null;
				p = p == ultima ? null : lista.next(p);
			}
		}
		return contador;
	}
	
	public <E> int cantidadAparicionesBis(E elemento, PositionList<E> lista) {
		int contador = 0;
		if (lista.isEmpty() == false) {
			Position<E> ultima = lista.last();
			Position<E> p = lista.first();
			boolean seguir = true;
			while ( seguir ) {
				if ( p.element().equals(elemento) ) contador++;
				if ( p == ultima ) seguir = false;
				else p = lista.next(p);
			}
		}
		return contador;
	}
	
	// Si me dejan usar el iterador:
	public <E> int cantidadAparicionesBisBis(E elemento, PositionList<E> lista) {
		int contador = 0;
		for ( E item : lista) 
			if (item.equals(elemento)) contador++;
		return contador;
	}
	
	
	// Si me dejan usar el iterador:
	public <E> int cantidadAparicionesBisBis(E elemento, PositionList<E> lista) {
		int contador = 0;
		for ( Position<E> p : lista.positions()) 
			if (p.element().equals(elemento)) contador++;
		return contador;
	}
	
	public <E> boolean ejercicio2(E elemento, PositionList<E> lista) {
		return aparece(elemento, lista);
	}
	
	// Ineficiente porque recorre la lista exhaustivamente:
	public <E> boolean aparece(E elemento, PositionList<E> lista) {
		return cantidadApariciones(elemento, lista) != 0;
	}
	
	public <E> boolean apareceBis(E elemento, PositionList<E> lista) {
		boolean encontrado = false;
		if ( !lista.isEmpty() ) {
			Position<E> p = lista.first();
			while ( p != null && !encontrado) {
				if (p.element().equals(elemento)) encontrado = true;
				else p = p == lista.last() ? null : lista.next(p);
			}
		}
		return encontrado;
	}
	
	// Si me dejan usar el iterador:
	public <E> boolean apareceBisBis(E elemento, PositionList<E> lista) {;
		for ( E item : lista) 
			if (item.equals(elemento)) return true;
		return false;
	}
	
	// Si me dejan usar el iterador.
	public <E> boolean apareceBisBisBis(E elemento, PositionList<E> lista) {;
		boolean resultado = false;
		Iterator<E> it = lista.iterator();
		while (it.hasNext() && resultado == false) {
			E item = it.next();
			resultado = item.equals(elemento);
		}
		return resultado;
	}


// Si me dejan usar el iterador.
	public <E> boolean apareceBisBisBis(E elemento, PositionList<E> lista) {;
		boolean resultado = false;
		Iterator<E> it = lista.iterator();
		while (it.hasNext() && resultado == false) {
			resultado = it.next().equals(elemento);
		}
		return resultado;
	}
	
	// Si me dejan usar el iterador.
	// Este es una exageracion pero funciona porque && usa
	// short-circuit evaluation
	public <E> boolean apareceBisBisBis(E elemento, PositionList<E> lista) {;
		boolean resultado = false;
		Iterator<E> it = lista.iterator();
		while (it.hasNext() && !(resultado = it.next().equals(elemento))) {
		}
		return resultado;
	}
	
		
	
	
// Si me dejan usar el iterador.
	public <E> boolean apareceBisBisBis(E elemento, PositionList<E> lista) {;
		boolean encontre = false;
		Iterator<E> it = lista.iterator();
		while (it.hasNext() && !encontre) {
			E item = it.next();
			if (item.equals(elemento)) encontre = true;
		}
		return encontre;
	}


	public <E> boolean ejercicio3(PositionList<E> lista1, PositionList<E> lista2) {
		return sonIguales(lista1, lista2);
	}
	
	public <E> boolean sonIguales(PositionList<E> lista1, PositionList<E> lista2) {
		if (lista1.size() != lista2.size()) return false;
		if (lista1.isEmpty() && lista2.isEmpty() ) return true;
		
		// Tienen el mismo tamaño y no son vacias
		boolean resultado = true;
		Position<E> p1 = lista1.first();
		Position<E> p2 = lista2.first();
		// La condicion p2 != null es innecesaria:
		while (p1 != null && p2 != null && resultado == true) {
			E item1 = p1.element();
			E item2 = p2.element();
			if (item1.equals(item2) == false) resultado = false;
			else {
				p1 = (p1 == lista1.last()) ? null : lista1.next(p1);
				p2 = (p2 == lista2.last()) ? null : lista2.next(p2);
			}
		}
		return resultado;
	}
	
	public <E> boolean sonIguales(PositionList<E> lista1, PositionList<E> lista2) {
		if (lista1.size() != lista2.size()) return false;
		if (lista1.isEmpty() && lista2.isEmpty() ) return true;
		
		// Tienen el mismo tamaño y no son vacias
		boolean resultado = true;
		Position<E> p1 = lista1.first();
		Position<E> p2 = lista2.first();
		// La condicion p2 != null es innecesaria:
		while (p1 != null && p2 != null && resultado == true) {
			E item1 = p1.element();
			E item2 = p2.element();
			resultado = !item1.equals(item2);
			p1 = (p1 == lista1.last()) ? null : lista1.next(p1);
			p2 = (p2 == lista2.last()) ? null : lista2.next(p2);
		}
		return resultado;
	}
	
	public <E> boolean sonIguales(PositionList<E> lista1, PositionList<E> lista2) {
		if (lista1.size() != lista2.size()) return false;
		if (lista1.isEmpty() && lista2.isEmpty() ) return true;
		
		// Tienen el mismo tamaño y no son vacias
		Iterator<E> it2 = lista2.iterator();
		for (E item1 : lista1) {
			E item2 = it2.next();
			if( !item1.equals(item2) ) return false;
		}
		return true;
	}
	
	// Alguien comento que mezcla niveles de abstraccion y por no le
	// resulta estetico. Es un argumento valido.
	public <E> boolean sonIguales(PositionList<E> lista1, PositionList<E> lista2) {
		if (lista1.size() != lista2.size()) return false;
		if (lista1.isEmpty() && lista2.isEmpty() ) return true;
		
		// Tienen el mismo tamaño y no son vacias
		Iterator<E> it2 = lista2.iterator();
		for (E item1 : lista1) {
			if( !item1.equals(it2.next()) ) return false;
		}
		return true;
	}
	
	
	public <E> boolean ejercicio4(PositionList<E> lista1, PositionList<E> lista2) {
		return estaIncluida(lista1, lista2);
	}
	
	// Computa si lista1 está incluida en lista2:
	public <E>  boolean estaIncluida(PositionList<E> lista1, PositionList<E> lista2) {
		if (lista1.isEmpty()) return true;
		if (lista2.isEmpty()) return false;
		if (lista1.size() > lista2.size()) return false;
		
		Position<E> p2 = lista2.first();
		boolean encontre = false;
		while (p2 != null && encontre == false ) {
			encontre = estaAdentro( lista1, lista2, p2 );
			p2 = p2 == lista2.last()? null : lista2.next(p2);
		}
		return encontre;
	}

	private <E>	boolean estaAdentro( PositionList<E> chiquita, PositionList<E> grande, Position<E> posgrande ) {
		boolean iguales = true;
		Position<E> p = chiquita.first();
		while ( iguales && p != null) {
			if ( posgrande == null ) iguales = false;
			else if (p.element().equals(posgrande.element()) == false)
				         iguales = false;
				 else {
				          p = p == chiquita.last() ? null : chiquita.next(p);
				          posgrande = posgrande == grande.last() ? null : grande.next(posgrande);
				}
		}
		return iguales; 
	}
	
	
	
}
	

