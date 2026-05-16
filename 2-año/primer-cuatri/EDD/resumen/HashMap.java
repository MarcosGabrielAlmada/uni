import tda.Map;

import excepciones.InvalidKeyException;

import tda.Entry;
import tda.Position;
import tda.PositionList;

public class HashMap<K,V> implements Map<K,V> {
    private ListaDEC<Entrada<K,V>>[] bucket;
    private int cant;
    private float factorDeCarga;

    public HashMap(int tam) {
        this.bucket = new ListaDEC[tam];
        this.factorDeCarga = 0;
        this.cant = 0;
    }

    public int size() {
        return this.cant;
    }

	public boolean isEmpty() {
        return this.cant == 0;
    }

	public V get(K key) {
        Position<Entrada<K,V>> p = this.buscarPosition(key);
        if (p != null) {
            return p.element().getValue();
        } else {
            return null;
        }
    }


	public V put(K key, V value) {
        // buscar con el hash, y recorrer la lista para ver si esta
        // si esta se reemplaza
        // sino se agrega

        if (key == null)
            throw new InvalidKeyException("Clave nula");

        ListaDEC<Entrada<K,V>> lista = this.bucket[this.hash(key)];
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
        if (this.factorDeCarga > 1) {
            this.rehash();
        }
        return null;
    }

	public V puts(K key, V value) {


        Position<Entrada<K,V>> p;
        try {
            p = this.buscarPosition(key);
        } catch (InvalidKeyException e) {

            // no existe (clave nula)

            if (key == null)
                throw new InvalidKeyException("Clave nula");
        }

        // existe y esta en el hashmap (hay que reemplazar)
        // o existe pero no esta en el hashmap

        ListaDEC<Entrada<K,V>> lista;
        try {
            lista = this.buscarLista(key);
        } catch (Exception e) {
//FALTA REHASH
            // existe pero no esta en el hashmap

            lista = this.bucket[hash(key)];
            if (lista == null)
                lista = new ListaDEC<Entrada<K,V>>();
            lista.addLast(new Entrada<K,V>(key, value));
            this.cant++;
            return null;
        }

        // existe y esta en el hash (hay que reemplazar)

        if (lista == null)
            lista = new ListaDEC<Entrada<K,V>>();
        V aux = p.element().getValue();
        p.element().setValue(value);
        this.cant++;

        return aux;

    }

	public V remove(K key) { // XXX
        Position<Entrada<K,V>> p = this.buscarPosition(key); // este metodo devuelve la excepcion
        PositionList<Entrada<K,V>> l = this.buscarLista(key);

        V aux = p.element().getValue();
        p.element().setValue(null);
        l.remove(p);
        this.cant--;
        return aux;
    }

    private Position<Entrada<K,V>> buscarPosition(K key) {
        if (key != null) {
            for (int i = 0; i < this.size(); i++) {
                if (this.bucket[i] != null) {
                    for (Position<Entrada<K,V>> p : this.bucket[i].positions()) {
                        if (p.element().getKey() == key) {
                            return p;
                        }
                    }
                }
            }
        }
        throw new InvalidKeyException("Invalid Key");
    }

    private ListaDEC<Entrada<K,V>> buscarLista(K key) {
        for (int i = 0; i < this.size(); i++) {
            if (this.bucket[i] != null) {
                for (Position<Entrada<K,V>> p : this.bucket[i].positions()) {
                    if (p.element().getKey() == key) {
                        return this.bucket[i];
                    }
                }
            }
        }
        throw new InvalidKeyException("Invalid Key");
    }

    private int proximoPrimo(int i) {
        boolean esPrimo = true;
        while (esPrimo) {
            for (int j = 2; j < i && esPrimo; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                }
            }
            esPrimo = true;
            i++;
        }
        return i;
    }

    private int hash(K k) {
        return k.hashCode() % this.size();
    }

    private void rehash() {
        ListaDEC<Entrada<K,V>>[] nuevo = new ListaDEC[this.proximoPrimo(this.bucket.length)];
        for (int i = 0; i < this.bucket.length; i++) {
            if (this.bucket[i] != null) {
                for (Entrada<K,V> e : this.bucket[i]) {
                    nuevo[this.hash(e.getKey())].addLast(e);
                }
            }
        }
        this.bucket = nuevo;
    }

	public Iterable<K> keys() {
        ListaDEC<K> lista = new ListaDEC<K>();
        for (int i = 0; i < this.size(); i++) {
            if (this.bucket[i] != null) {
                for (Entry<K,V> e : this.bucket[i]) {
                    lista.addLast(e.getKey());
                }
            }
        }
        return lista;
    }

	public Iterable<V> values() {
        ListaDEC<V> lista = new ListaDEC<V>();
        for (int i = 0; i < this.size(); i++) {
            if (this.bucket[i] != null) {
                for (Entry<K,V> e : this.bucket[i]) {
                    lista.addLast(e.getValue());
                }
            }
        }
        return lista;
    }

	public Iterable<Entry<K,V>> entries() {
        ListaDEC<Entry<K,V>> lista = new ListaDEC<Entry<K,V>>();
        for (int i = 0; i < this.size(); i++) {
            if (this.bucket[i] != null) {
                for (Entry<K,V> e : this.bucket[i]) {
                    lista.addLast(e);
                }
            }
        }
        return lista;
    }
}
