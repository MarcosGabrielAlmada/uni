package ar.edu.uns.cs.ed.tdas.tps.tp5;

import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tps.tp4.ListDEC;

public class HashMap<K,V> implements Map<K,V> {
    private final float LIMITE_FACTOR_CARGA = 0.75f;
    private ListDEC<Entrada<K,V>>[] bucket;
    private int cant;
    private float factorDeCarga;

    public HashMap() {
        this.bucket = new ListDEC[13];
        for (int i = 0; i < this.bucket.length; i++) {
            this.bucket[i] = new ListDEC<Entrada<K,V>>();
        }
        this.factorDeCarga = 0;
        this.cant = 13;
    }

    public int size() {
        return this.cant;
    }

	public boolean isEmpty() {
        return this.cant == 0;
    }

	public V get(K key) {
        if (key == null)
            throw new InvalidKeyException("Clave nula");
        ListDEC<Entrada<K,V>> lista = this.bucket[this.hash(key)];
        for (Entrada<K,V> e : lista) {
            if (e.getKey() == key) {
                return e.getValue();
            }
        }
        throw new InvalidKeyException("La clave no pertenece");
        
    }


	public V put(K key, V value) {
        // buscar con el hash, y recorrer la lista para ver si esta
        // si esta se reemplaza
        // sino se agrega

        if (key == null)
            throw new InvalidKeyException("Clave nula");

        ListDEC<Entrada<K,V>> lista = this.bucket[this.hash(key)];
        for (Entrada<K,V> e : lista) {
            if (e.getKey() == key) {
                V aux = e.getValue();
                e.setValue(value);

                return aux;
            }
        }

        lista.addLast(new Entrada<K,V>(key, value));
        this.cant++;
        this.factorDeCarga = this.cant/this.bucket.length;
        if (this.factorDeCarga > LIMITE_FACTOR_CARGA) {
            this.rehash();
        }
        return null;
    }

	public V remove(K key) {
        if (key == null)
            throw new InvalidKeyException("Clave nula");

        ListDEC<Entrada<K,V>> lista = this.bucket[this.hash(key)];
        for (Position<Entrada<K,V>> p : lista.positions()) {
            if (p.element().getKey() == key) {
                V aux = p.element().getValue();
                lista.remove(p);
                this.cant--;
                return aux;
            }
        }
        throw new InvalidKeyException("La clave no pertenece");
    }

    // private Position<Entrada<K,V>> buscarPosition(K key) {
    //     if (key != null) {
    //         for (int i = 0; i < this.size(); i++) {
    //             if (this.bucket[i] != null) {
    //                 for (Position<Entrada<K,V>> p : this.bucket[i].positions()) {
    //                     if (p.element().getKey() == key) {
    //                         return p;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     throw new InvalidKeyException("Invalid Key");
    // }

    // private ListaDEC<Entrada<K,V>> buscarLista(K key) {
    //     for (int i = 0; i < this.size(); i++) {
    //         if (this.bucket[i] != null) {
    //             for (Position<Entrada<K,V>> p : this.bucket[i].positions()) {
    //                 if (p.element().getKey() == key) {
    //                     return this.bucket[i];
    //                 }
    //             }
    //         }
    //     }
    //     throw new InvalidKeyException("Invalid Key");
    // }

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

    private int hash(K k) {
        return k.hashCode() % this.size();
    }

    private void rehash() {
        ListDEC<Entrada<K,V>>[] nuevo = new ListDEC[this.proximoPrimo(this.bucket.length*2)];

        for (int i = 0; i < nuevo.length; i++) {
            nuevo[i] = new ListDEC<Entrada<K,V>>();
        }

        for (int i = 0; i < this.bucket.length; i++) {
            for (Entrada<K,V> e : this.bucket[i]) {
                nuevo[this.hash(e.getKey())].addLast(e);
            }
        }
        this.bucket = nuevo;
    }

	public Iterable<K> keys() {
        ListDEC<K> lista = new ListDEC<K>();
        for (int i = 0; i < this.size(); i++) {
            for (Entry<K,V> e : this.bucket[i]) {
                lista.addLast(e.getKey());
            }
        }
        return lista;
    }

	public Iterable<V> values() {
        ListDEC<V> lista = new ListDEC<V>();
        for (int i = 0; i < this.size(); i++) {
            for (Entry<K,V> e : this.bucket[i]) {
                lista.addLast(e.getValue());
            }
        }
        return lista;
    }

	public Iterable<Entry<K,V>> entries() {
        ListDEC<Entry<K,V>> lista = new ListDEC<Entry<K,V>>();
        for (int i = 0; i < this.size(); i++) {
            for (Entry<K,V> e : this.bucket[i]) {
                lista.addLast(e);
            }
        }
        return lista;
    }
}
