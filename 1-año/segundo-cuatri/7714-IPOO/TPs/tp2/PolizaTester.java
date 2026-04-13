import java.util.Scanner;

public class PolizaTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese los datos de la poliza:");
    
    int nroPoliza;
    do {
      System.out.print("Nro Poliza: ");
      nroPoliza = scanner.nextInt();

      if(nroPoliza <= 0) { System.out.println("Error: el valor debe ser positivo"); }

      System.out.println("");
      } while (nroPoliza <= 0);
    

    int incendio;
    do {
      System.out.print("Nro Incendio: ");
      incendio = scanner.nextInt();

      if(incendio <= 0) { System.out.println("Error: el Valor debe ser positivo"); }

      System.out.println("");
      } while (incendio <= 0);
    

    int robo;
    do {
      System.out.print("Nro Robo: ");
      robo = scanner.nextInt();

      if(robo <= 0) { System.out.println("Error: el Valor debe ser positivo"); }

      System.out.println("");
      } while (robo <= 0);


    Poliza pol = new Poliza(nroPoliza, incendio, robo);

    System.out.println("");
    pol.actualizarPorcentaje(20);
    pol.desactivar();
    pol.actualizarPorcentaje(10);
    pol.activar();
    System.out.println(pol.toString());


    
  scanner.close();
  }
}