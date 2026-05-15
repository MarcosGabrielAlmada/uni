import tda.Map;
import tda.Entry;
import tda.Position;
import tda.PositionList;

public class HashMap<K,V> implements Map<K,V> {
    private ListaDEC<Entrada<K,V>>[] arreglo;
    private int cant;
    private int factorDeCarga;

    public HashMap(int tam) {
        this.arreglo = new ListaDEC[tam];
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
        Position<Entrada<K,V>> p = this.buscarPosition(key);
        if (p != null) {
            V aux = p.element().getValue();
            p.element().setValue(value);
            this.cant++;
            return aux;
        } else {

            return null;
        }
    }
	
	public V remove(K key) {
        Position<Entrada<K,V>> p = this.buscarPosition(key);
        if (p != null) {
            PositionList<Entrada<K,V>> l = this.buscarLista(key);
            V aux = p.element().getValue();
            p.element().setValue(null);
            l.remove(p);
            this.cant--;
            return aux;
        } else {
            return null;
        }
    }

    private Position<Entrada<K,V>> buscarPosition(K key) {
        for (int i = 0; i < this.size(); i++) {
            for (Position<Entrada<K,V>> p : this.arreglo[i].positions()) {
                if (p.element().getKey() == key) {
                    return p;
                }
            }
        }
        return null;
    }

    private PositionList<Entrada<K,V>> buscarLista(K key) {
        for (int i = 0; i < this.size(); i++) {
            for (Position<Entrada<K,V>> p : this.arreglo[i].positions()) {
                if (p.element().getKey() == key) {
                    return this.arreglo[i];
                }
            }
        }
        return null;
    }

    private int hash(K k, V v) {
        return k.hashCode() % this.size();
    }
	
	public Iterable<K> keys() {
        return null;
    }
	
	public Iterable<V> values() {
        return null;
    }
	
	public Iterable<Entry<K,V>> entries() {
        return null;
    }
}
