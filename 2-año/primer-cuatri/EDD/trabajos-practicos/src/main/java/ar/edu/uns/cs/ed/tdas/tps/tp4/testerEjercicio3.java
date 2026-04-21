package ar.edu.uns.cs.ed.tdas.tps.tp4;

public class testerEjercicio3 {
    public static void main(String[] args) {
        ListaDEC<String> lista = new ListaDEC<>();
        lista.addFirst("1");
        lista.addFirst("1");
        lista.addFirst("1");
        lista.addFirst("2");
        lista.addFirst("3");
        lista.addFirst("4");
        lista.addFirst("5");
        System.out.println(lista.toString());

        Ejercicios e = new Ejercicios();
        System.out.println("0 esta en la lista?: " + e.e3a(lista, "0"));
        System.out.println("1 esta en la lista?: " + e.e3a(lista, "1"));
        System.out.println("3 esta en la lista?: " + e.e3a(lista, "3"));


        System.out.println();
        System.out.println("0 esta " + e.e3b(lista, "0") + " veces");
        System.out.println("1 esta " + e.e3b(lista, "1") + " veces");
        System.out.println("3 esta " + e.e3b(lista, "3") + " veces");


        System.out.println();
        System.out.println("0 esta al menos 1 veces?: " + e.e3c(lista, "0", 1));
        System.out.println("1 esta al menos 3 vez?: " + e.e3c(lista, "1", 3));
        System.out.println("1 esta al menos 1 veces?: " + e.e3c(lista, "1", 1));
        System.out.println("3 esta al menos 1 veces?: " + e.e3c(lista, "3", 1));
        System.out.println("3 esta al menos 1 veces?: " + e.e3c(lista, "3", 2));
    }
}