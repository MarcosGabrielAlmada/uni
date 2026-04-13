import java.util.Scanner;

public class SurtidorSimulador {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    Surtidor surtidor = new Surtidor();

    int n;
    do {
      System.out.print("Ingrese la cantidad de repeticiones del programa: ");
      n = scanner.nextInt();

      if (n<1) System.out.print("Error: la cantidad debe ser mayor o igual a 1...\n");      
    } while (n<1);

    for (int i=1; i<=n; i++) {
      System.out.println("Cantidades de combustible:");
      System.out.println("Gasoil: " + surtidor.obtenerLitrosGasoil());
      System.out.println("Super: " + surtidor.obtenerLitrosSuper());
      System.out.println("Premium: " + surtidor.obtenerLitrosPremium());
      System.out.println();

      int opcion;
      do {
        System.out.println("Opciones:");
        System.out.println("1: leer litros a cargar y cargar Gasoil");
        System.out.println("2: leer litros a cargar y cargar Super");
        System.out.println("3: leer litros a cargar y cargar Premium");
        System.out.println("4: llenar Deposito Gasoil");
        System.out.println("5: llenar Deposito Super");
        System.out.println("6: llenar Deposito Premium");
        System.out.println("");
        System.out.print("Elija una opcion: ");
        opcion = scanner.nextInt();

        if (opcion<1 || opcion>6) System.out.println("Error: la opcion debe estar entre 1 y 6...\n");
      } while (opcion < 1 || opcion > 6);

      switch (opcion) {
        case 1:
          int litros = surtidor.obtenerLitrosGasoil();
          
          if (litros>0) {
            System.out.println("Hay "+litros+" litros de Gasoil");

            boolean bandera;

            do {
              int litrosExtraer;
              do {
                System.out.print("Ingresar la cantidad de litros a cargar: ");
                litrosExtraer = scanner.nextInt();
              } while (litrosExtraer <= 0);

              bandera = surtidor.extraerDepositoGasoil(litrosExtraer);

              if (!bandera) {
                System.out.println("Error: la cantidad ingresada no es válida.");
              }

            } while (!bandera);
          } else { System.out.println("No hay combustible."); }

          
          break;
        case 2:
          
          break;
        case 3:
          
          break;
        case 4:
          surtidor.llenarDepositoGasoil();
          System.out.println("Deposito de Gasoil llenado.");
          break;
        case 5:
          surtidor.llenarDepositoSuper();
          System.out.println("Deposito de Super llenado.");
          break;
        case 6:
          surtidor.llenarDepositoPremium();
          System.out.println("Deposito de Premium llenado.");
          break;
        
      }
    }
    scanner.close();
  }
}