package ar.edu.uns.cs.ed.tdas.tps.tp5;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEntryException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;

public class Diccionario<K,V> implements Dictionary<K,V> {
    private final float LIMITE_FACTOR_CARGA = 0.75f;
    private ListDEC<Entrada<K,V>>[] bucket;
    private int cant;
    private float factorDeCarga;


    public Diccionario() {
        this.bucket = new ListDEC[13];
		for (int i = 0; i < this.bucket.length; i++) {
			this.bucket[i] = new ListDEC<Entrada<K,V>>();
		}
		this.factorDeCarga = 0;
        this.cant = 0;
    }

    /**
	 * Consulta el número de entradas del diccionario.
	 * @return Número de entradas del diccionario.
	 */
	public int size() {
        return this.cant;
    }
	
	/**
	 * Consulta si el diccionario está vacío.
	 * @return Verdadero si el diccionario está vacío, falso en caso contrario.
	 */
	public boolean isEmpty() {
        return this.cant == 0;
    }
	
	/**
	 * Busca una entrada con clave igual a una clave dada y la devuelve, si no existe retorna nulo.
	 * @param key Clave a buscar.
	 * @return Entrada encontrada.
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida.
	 */
	public Entry<K,V> find(K key) {
        if (key == null)
            throw new InvalidKeyException("Clave nula");

		for (Entrada<K,V> e : this.bucket[this.hash(key, this.bucket.length)]) {
			if (e.getKey().equals(key)) {
				return e;
			}
		}

		return null;
    }
	
	/**
	 * Retorna una colección iterable que contiene todas las entradas con clave igual a una clave dada.
	 * @param key Clave de las entradas a buscar.
	 * @return Colección iterable de las entradas encontradas.
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida.
	 */
	public Iterable<Entry<K,V>> findAll(K key) {
        if (key == null)
            throw new InvalidKeyException("Clave nula");

        ListDEC<Entry<K,V>> all = new ListDEC<Entry<K,V>>();
		for (int i = 0; i < this.bucket.length; i++) {
			for (Entrada<K,V> e : this.bucket[i]) {
				if (e.getKey().equals(key)) {
					all.addLast(e);
				}
			}
		}

        return all;
    }
	
	/**
	 * Inserta una entrada con una clave y un valor dado en el diccionario y retorna la entrada creada.
	 * @param key Clave de la entrada a crear.
	 * @return value Valor de la entrada a crear.
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida.
	 */
	public Entry<K,V> insert(K key, V value) {
		if (key == null)
			throw new InvalidKeyException("Clave nula");

		Entrada<K,V> e = new Entrada<K,V>(key, value);
		this.bucket[this.hash(key, this.bucket.length)].addLast(e);

		this.cant++;
		this.factorDeCarga = (float)this.cant / this.bucket.length;
		if (factorDeCarga > LIMITE_FACTOR_CARGA) {
			this.rehash();
		}
		return e;
    }

	/**
	 * Remueve una entrada dada en el diccionario y devuelve la entrada removida.
	 * @param e Entrada a remover.
	 * @return Entrada removida.
	 * @throws InvalidEntryException si la entrada no está en el diccionario o es inválida.
	 */
	public Entry<K,V> remove(Entry<K,V> e) {
		if (e == null)
			throw new InvalidEntryException("Entrada nula");

		ListDEC<Entrada<K,V>> lista = this.bucket[this.hash(e.getKey(), this.bucket.length)];
		for (Position<Entrada<K,V>> p : lista.positions()) {
			if (e == p.element()) {
				lista.remove(p);
				this.cant--;
				return e;
			}
		}

		throw new InvalidEntryException("La clave no pertenece");
    }

	private int hash(K k, int length) {
        return Math.abs(k.hashCode()) % length;
    }

	public void rehash() {
		ListDEC<Entrada<K,V>>[] nuevo = new ListDEC[this.proximoPrimo(this.bucket.length*2)];

        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = new ListDEC<Entrada<K,V>>(); // esto se podria meter en el otro for, con un if
        }

		for (int i = 0; i < this.bucket.length; i++) {
			for (Entrada<K,V> e : this.bucket[i]) {
				nuevo[this.hash(e.getKey(), nuevo.length)].addLast(e);
			}
		}
		this.bucket = nuevo;
	}

	private int proximoPrimo(int i) {
        boolean esPrimo;
        while (true) {
            esPrimo = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }

            if (esPrimo)
                return i;

            i++;
        }
    }
	
	/**
	 * Retorna una colección iterable con todas las entradas en el diccionario.
	 * @return Colección iterable de todas las entradas.
	 */
	public Iterable<Entry<K,V>> entries() {
		ListDEC<Entry<K,V>> lista = new ListDEC<Entry<K,V>>();
		for (int i = 0; i < this.bucket.length; i++) {
			for (Entry<K,V> e : this.bucket[i]) {
				lista.addLast(e);
			}
		}
		return lista;
    }


	// ------------------ EJERCICIO 5 A) ------------------
	/**
	 * Elimina todas aquellas entradas con clave c y valor v.
	 * @return Colección iterable con todas las entradas eliminadas.
	 */
	public Iterable<Entry<K,V>> eliminarTodas(K c,V v) throws InvalidKeyException {
		if (c == null) // c1
			throw new InvalidKeyException("Key C nula"); // c2

		PositionList<Entry<K,V>> lista = new ListDEC<>(); // c3
		for (Entry<K,V> e : this.entries()) { // c4 + T_this.entries(n) = c4 + n
			if (e.getKey().equals(c) && e.getValue().equals(v)) { // c5 + c6 + c7 + c8 + c9 + c10
				lista.addLast(e); // c11
				this.remove(e); // c12 + O(1) promedio --- ó --- c12 + O(n) peor caso
				// remove -> n + (n-1) + ... + 1 = O(n), por cada eliminacion va a estar buscando en (n-i), siendo i la cantidad de iteraciones menos 1
			}
		}
		return lista; // c13
	}

	// T(n) = c1 + c3 + c4 + T_this.entries(n) + n * (c5 + c6 + c7 + c8 + c9 + c10 + c11 + c12 + O(n)) + c13
	//      = const1 + n + n * (const2 + O(n))
	//      = const1 + n * ( 1 + const2 + O(n))
	//      = O(n^2) donde n = |this|
}
