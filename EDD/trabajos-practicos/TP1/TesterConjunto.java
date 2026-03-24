public class TesterConjunto {
    public static void main(String[] a) {
        Conjunto<Integer> c1 = new ConjuntoArreglo<Integer>(3);
        Conjunto<Integer> c2 = new ConjuntoArreglo<Integer>(3);

        c1.put(1);
        c1.put(2);
        c1.put(3);

        c2.put(3);
        c2.put(4);

        System.out.println();
        System.out.println(c1);
        System.out.println("Size: " + c1.size());
        System.out.println("Capacity: " + c1.capacity());
        System.out.println("isEmpty: " + c1.isEmpty());

        System.out.println();
        System.out.println(c2);
        System.out.println("Size: " + c2.size());
        System.out.println("Capacity: " + c2.capacity());
        System.out.println("isEmpty: " + c2.isEmpty());

        Conjunto<Integer> c3 = c1.interseccion(c2);
        
        System.out.println();
        System.out.println(c3);
        System.out.println("Size: " + c3.size());
        System.out.println("Capacity: " + c3.capacity());
        System.out.println("isEmpty: " + c3.isEmpty());
        System.out.println("[" + c3.get(0) + "][" + c3.get(1) + "][" + c3.get(2) + "]");


    }
}
