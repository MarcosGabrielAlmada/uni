public class TesterProblema2{
    public static void main (String args[]){
        Alfa a1, a2, a3;
        Beta b1, b2;
        Delta  c1, c2, c3;

        //a1 = new Alfa(); //Error en compilación: Se intenta instanciar una clase abstracta  
        a2 = new Beta();
        b1 = new Beta();
        //c1 = new Beta(); //Error en compilación: Incompatibilidad de tipos
        b2 = new Delta(5);
        c2 = (Delta) b2;
        a3 = new Delta(15);
        c3 = null;

        System.out.println("12: "+a2.n()); //n en Alfa
        System.out.println("13: "+b2.n()); //n en Delta 50
        //System.out.println("14: "+a2.p()); //Error en compilación:  el método p no está definido en Alfa
        System.out.println("15: "+a2.m()); //m en Alfa 1 n en Alfa
        
        System.out.println("16: "+b1.n()); //n en Alfa
        System.out.println("17: "+c2.n(2)); //n en Beta 20
        System.out.println("18: "+b1.p()); //p en Beta 10
        //System.out.println("19: "+c3.m()); //Error en ejecución:  c3 is null
        System.out.println("20: "+a3.m()); //m en Delta 15 m en Alfa 1 n en Delta 150
    }
}
