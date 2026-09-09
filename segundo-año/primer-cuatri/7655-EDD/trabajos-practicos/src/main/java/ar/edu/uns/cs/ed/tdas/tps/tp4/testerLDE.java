package ar.edu.uns.cs.ed.tdas.tps.tp4;
import java.util.Iterator;

public class testerLDE {
    public static void main(String[] args) {
        ListDEC<String> lista = new ListDEC<>();
        lista.addFirst("1");
        lista.addFirst("2");
        lista.addFirst("3");
        lista.addFirst("4");
        lista.addFirst("5");
        System.out.println(lista.toString());

        lista.addLast("ultimo");
        System.out.println(lista.toString());

        lista.addBefore(lista.last(), "antes del ultimo");
        lista.addAfter(lista.first(), "despues del primero");
        lista.addBefore(lista.first(), "antes del primero");
        lista.addAfter(lista.last(), "despues del ultimo");
        System.out.println(lista.toString());
        
        lista.remove(lista.first());     
        System.out.println(lista.toString());

        lista.set(lista.first(), "Hola Mundo");
        System.out.println(lista.toString());

        Iterator<String> it = lista.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }    
}
