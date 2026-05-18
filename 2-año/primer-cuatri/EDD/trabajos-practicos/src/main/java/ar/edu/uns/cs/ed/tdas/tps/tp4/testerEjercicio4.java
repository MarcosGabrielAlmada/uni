package ar.edu.uns.cs.ed.tdas.tps.tp4;

import java.util.Iterator;

public class testerEjercicio4 {
    public static void main(String[] args) {
        ListDEC<String> lista = new ListDEC<>();
        lista.addFirst("1");
        lista.addFirst("2");
        lista.addFirst("3");
        System.out.println(lista.toString());

        Ejercicios e = new Ejercicios();
        System.out.println(e.e4(lista));


    }
}
