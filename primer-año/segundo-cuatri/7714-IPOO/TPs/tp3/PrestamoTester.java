import java.util.Scanner;

public class PrestamoTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Libro libro1 = new Libro("Titulo 1", "Autor 1", "Editorial 1", 'M');
    Libro libro2 = new Libro("Titulo 2", "Autor 2", "Editorial 2", 'A');
    Fecha fechaP1 = new Fecha(4, 9, 2025);
    Fecha fechaP2 = new Fecha(2, 9, 2025);
    Fecha fechaD1 = new Fecha(5, 10, 2025);
    Fecha fechaD2 = new Fecha(4, 10, 2025);
    Prestamo prestamo1 = new Prestamo(libro1, fechaP1, fechaD1, "");
    Prestamo prestamo2 = new Prestamo(libro2, fechaP2, fechaD2, "");

    System.out.println("Ingrese la fecha de hoy...");
    System.out.print("Dia: ");
    int dia = scanner.nextInt();
    System.out.print("Mes: ");
    int mes = scanner.nextInt();
    System.out.print("Año: ");
    int año = scanner.nextInt();


    if (prestamo1.estaAtrasado(new Fecha(dia, mes, año))) System.out.println("\nEl libro 1 esta atrasado, debe devolverlo");
    else System.out.println("\nEl libro 1 esta en regla");

    if (prestamo1.estaAtrasado(new Fecha(dia, mes, año))) System.out.println("\nEl libro 1 esta atrasado, debe devolverlo");
    else System.out.println("\nEl libro 1 esta en regla");


    System.out.println("El libro mas atrasado es\n"+(prestamo1.masAntiguo(prestamo2)).obtenerLibro());

    System.out.println("Los libros son iguales?: "+prestamo1.equals(prestamo2));

    scanner.close();
  }  
}
