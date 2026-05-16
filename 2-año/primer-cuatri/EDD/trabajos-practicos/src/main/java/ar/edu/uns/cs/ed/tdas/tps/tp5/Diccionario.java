package ar.edu.uns.cs.ed.tdas.tps.tp5;

import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;
import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListaDEC;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEntryException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;

public class Diccionario<K,V> implements Dictionary<K,V> {
    private final float LIMITE_FACTOR_CARGA = 0.75f;
    private ListaDEC<Entrada<K,V>>[] bucket;
    private int cant;
    private float factorDeCarga;


    public Diccionario() {
        this.bucket = new ListaDEC[13];
		for (int i = 0; i < this.bucket.length; i++) {
			this.bucket[i] = new ListaDEC<Entrada<K,V>>();
		}
		this.factorDeCarga = 0;
        this.cant = 13;
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

		for (Entrada<K,V> e : this.bucket[this.hash(key)]) {
			if (e.getKey() == key) {
				return e;
			}
		}

        
        throw new InvalidKeyException("La clave no pertenece");
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

        ListaDEC<Entry<K,V>> all = new ListaDEC<Entry<K,V>>();
		for (int i = 0; i < this.bucket.length; i++) {
			for (Entrada<K,V> e : this.bucket[i]) {
				if (e.getKey() == key) {
					all.addLast(e);
				}
			}
		}

		if (all.isEmpty())
			throw new InvalidKeyException("La clave no pertenece");

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
		this.bucket[this.hash(key)].addLast(e);

		this.cant++;
		this.factorDeCarga = this.cant / this.bucket.length;
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

		ListaDEC<Entrada<K,V>> lista = this.bucket[this.hash(e.getKey())];
		for (Position<Entrada<K,V>> p : lista.positions()) {
			if (e == p.element()) {
				lista.remove(p);
				this.cant--;
				return e;
			}
		}

		throw new InvalidEntryException("La clave no pertenece");
    }

	public int hash(K k) {
		return k.hashCode() % this.size();
	}

	public void rehash() {
		ListaDEC<Entrada<K,V>>[] nuevo = new ListaDEC[this.proximoPrimo(this.bucket.length*2)];

        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = new ListaDEC<Entrada<K,V>>();
        }

		for (int i = 0; i < this.bucket.length; i++) {
			for (Entrada<K,V> e : this.bucket[i]) {
				nuevo[this.hash(e.getKey())].addLast(e);
			}
		}
		this.bucket = nuevo;
	}

	private int proximoPrimo(int i) {
        boolean esPrimo = true;
        while (esPrimo) {
            for (int j = 2; j < i && esPrimo; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                }
            }
            if (!esPrimo) {
                esPrimo = true;
                i++;
            }
        }
        return i;
    }
	
	/**
	 * Retorna una colección iterable con todas las entradas en el diccionario.
	 * @return Colección iterable de todas las entradas.
	 */
	public Iterable<Entry<K,V>> entries() {
		ListaDEC<Entry<K,V>> lista = new ListaDEC<Entry<K,V>>();

		for (int i = 0; i < this.bucket.length; i++) {
			for (Entry<K,V> e : this.bucket[i]) {
				lista.addLast(e);
			}
		}

		return lista;
    }
	
}
