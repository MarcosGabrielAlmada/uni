public class TesterRegistroVentas {
    public static void main(String[] args) {
        RegistroVentas r = new RegistroVentas(10);
        int n;
        float m;

        /*  Se establecen los valores de las ventas, las posiciones pares con venta igual a 50 y las 
            posiciones impares con venta igual a 200
        */
        for (int i = 0; i<r.longitud(); i++)
            if (i % 2 == 0)
                r.establecerVenta(i, 50);
            else
                r.establecerVenta(i, 200);

        // Se muestra por pantalla el contenido del registro de ventas
        mostrarRegistroVentas(r);
        

        System.out.println("\n\n\n--------------------------------------");
        System.out.println("Test de hayAlMenosNVentasSuperioresA");
        System.out.println("--------------------------------------");

        // En este punto, la mitad de las ventas registradas estan en 50 y la otra mitad en 200

        /*
         * Algunos posibles casos de prueba distintivos: 
         *  Primer caso:    se controla que la cantidad buscada (n) coincida con la cantidad que cumplen en el arreglo, usando para este
         *                  caso un n = mitad de venta y un m = 150, donde se espera entonces que retorne verdadero porque se sabe
         *                  que hay al menos esa cantidad ya que la mitad de las ventas son de 200.
         *             
         *  Segundo caso:   se controla que la cantidad buscada (n) sea menor que la cantidad que cumplen, usando en este caso los valores
         *                  n = mitad - 1 y un m = 150, donde se espera que retorne verdadero porque se sabe que hay al menos esa cantidad.
         * 
         *  Tercer caso:    se controla que la cantidad buscada supere la cantidad que cumplen, con un n = mitad + 1 y un m = 150, donde
         *                  se espera que retorne falso.
         * 
         *  Cuarto caso:    se controla que todas las ventas superen el monto deseado, con un n = tamaño del arreglo y m = 40, donde se
         *                  espera que retorne verdadero.
         * 
         *  Quinto caso:    se controla que la cantidad buscada supere el tamaño del arreglo, donde se espera que devuelva falso ya que
         *                  no alcanzarían las ventas para dicha cantidad
         */
        m = 150;
        n = (int)(r.longitud()/2);
        System.out.println("1° caso (coincide cantidad buscada y las que cumplen):\n\t¿Hay al menos " + n + " ventas superiores a " + m + "? Se espera que devuelva que SI, está devolviendo: " + ((r.alMenosNVentasSuperioresA(n, m))?"SI":"NO"));
        n--;
        System.out.println("2° caso (se busca menos de las que cumplen):\n\t¿Hay al menos " + n + " ventas superiores a " + m + "? Se espera que devuelva que SI, está devolviendo: " + ((r.alMenosNVentasSuperioresA(n, m))?"SI":"NO"));
        n+=2;
        System.out.println("3° caso (se busca más de las que cumplen):\n\t¿Hay al menos " + n + " ventas superiores a " + m + "? Se espera que devuelva que NO, está devolviendo: " + ((r.alMenosNVentasSuperioresA(n, m))?"SI":"NO"));
        m = 40;
        n = r.longitud();
        System.out.println("4° caso (se busca controlar que todas cumplan):\n\t¿Hay al menos " + n + " ventas superiores a " + m + "? Se espera que devuelva que SI, está devolviendo: " + ((r.alMenosNVentasSuperioresA(n, m))?"SI":"NO"));
        n++;
        System.out.println("5° caso (se busca más de las que hay guardadas):\n\t¿Hay al menos " + n + " ventas superiores a " + m + "? Se espera que devuelva que NO, está devolviendo " + ((r.alMenosNVentasSuperioresA(n, m))?"SI":"NO"));



        
        
        System.out.println("\n\n\n--------------------------------------");
        System.out.println("Test de diaVentaMinima");
        System.out.println("--------------------------------------");

        /*
         * Algunos posibles casos de prueba:
         *  Primer caso:    La menor venta se encuentra en la primera posición
         *  Segundo caso:   La menor venta se encuentra en una posición intermedia
         *  Tercer caso:    La menor venta se encuentra en la última posición
         */

        System.out.println("Cambiando el valor de la PRIMERA posicion para ser la menor venta");
        r.establecerVenta(0, 10);

        mostrarRegistroVentas(r);
        System.out.println("\n1° caso:\nDia de menor venta: " + (r.diaVentaMinima()+1));
        
        System.out.println();
        System.out.println("Cambiando el valor de la cuarta posicion para ser la menor venta");
        r.establecerVenta(0, 100);
        r.establecerVenta(3, 10);
        mostrarRegistroVentas(r);
        System.out.println("\n2° caso:\nDia de menor venta: " + (r.diaVentaMinima()+1));

        System.out.println();
        System.out.println("Cambiando el valor de ULTIMA primera posicion para ser la menor venta");
        r.establecerVenta(3, 100);
        r.establecerVenta(r.longitud()-1, 10);
        mostrarRegistroVentas(r);
        System.out.println("\n3°caso:\nDia de menor venta: " + (r.diaVentaMinima()+1));
    }


    // Muestra por pantalla el registro de venta enviado por parámetro
    private static void mostrarRegistroVentas(RegistroVentas r) {
        String formatoDia = " Dia %-3d |";
        String formatoVenta = "%8.2f |";
        System.out.println("Registro ventas: ");
        for (int i = 1; i<=r.longitud(); i++)
            System.out.print(String.format(formatoDia, i));
        System.out.println();
        for (int i = 0; i<r.longitud(); i++)
            System.out.print(String.format(formatoVenta, r.obtenerVenta(i)));
        System.out.println();
    }
}
