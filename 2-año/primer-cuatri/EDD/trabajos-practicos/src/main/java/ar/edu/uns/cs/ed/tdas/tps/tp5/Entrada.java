package ar.edu.uns.cs.ed.tdas.tps.tp5;
import ar.edu.uns.cs.ed.tdas.Entry;

public class Entrada<K,V> implements Entry<K,V> {
    private K key;
    private V value;

    public Entrada(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
