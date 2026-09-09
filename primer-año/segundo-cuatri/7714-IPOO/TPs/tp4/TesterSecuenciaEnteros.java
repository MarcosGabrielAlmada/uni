public class TesterSecuenciaEnteros {
  public static void main(String[] args) {
    SecuenciaEnteros sec = new SecuenciaEnteros(5);
    sec.establecerEntero(0,1);
    sec.establecerEntero(1,2);
    sec.establecerEntero(2,3);
    sec.establecerEntero(3,4);
    sec.establecerEntero(4,5);
    
    sec.toString();
    System.out.println("");
    
    System.out.println("total: " + sec.total());
    System.out.println("esta 1: " + sec.estaNum(1));
    System.out.println("esta 6: " + sec.estaNum(6));
    System.out.println("cantidad mayores a 3: " + sec.cantidadMayores(3));
    System.out.println("mitad mayores a 3: " + sec.mitadMayores(3));
    System.out.println("");
    
    SecuenciaEnteros sec1 = sec.clone();
    System.out.println(sec.equals(sec1));
    sec.establecerEntero(1,1);
    System.out.println(sec.equals(sec1));
  }
}
