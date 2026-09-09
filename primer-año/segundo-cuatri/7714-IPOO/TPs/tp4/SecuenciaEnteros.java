public class SecuenciaEnteros {
  // Atributos de instancia
  int [] sec;

  // Constructor
  public SecuenciaEnteros(int cant) {
    sec = new int[cant];
  }

  // Comandos
  public void establecerEntero(int p, int n) { sec [p] = n; }
  public void reemplazar(int n1, int n2) {
    for (int i=0; i<sec.length; i++)
      if (sec[i] == n1)
        sec[i] = n2;
  }

  public void reemplazar (int n) {
    int pri = -1;
    int ult = -1;
    for (int i=0; i<sec.length; i++){
      if (pri == -1 && sec[i] == n)
        pri = i;
      else if (pri != -1 && sec[i] == n)
        ult = i;
    }

    if (pri != -1) sec[pri] = 0;
    if (ult != -1) sec[ult] = 0;
  }

  public boolean intercambiar(int p1, int p2) {
    boolean res = false;
    if (0 <= p1 && p2 < cantElementos()) {
      int temp = sec[p2];
      sec[p2] = sec[p1];
      sec[p1] = temp;
      res = true;
    }
    return res;
  }

  public boolean copy(SecuenciaEnteros a) {
    boolean res = false;
    if (a != null && cantElementos() == a.cantElementos()) {
      for (int i=0; i<cantElementos(); i++) {
        sec[i] = a.obtenerEntero(i);
      }
      res = true;
    }
    return res;
  }

  // Consultas
  public int obtenerEntero(int p) { return sec[p]; }
  public int cantElementos() { return sec.length; }

  public int total() {
    int total = 0;
    for (int i=0; i<cantElementos(); i++) {
      total += obtenerEntero(i);
    }
    return total;
  }

  public boolean estaNum(int n) {
    boolean esta = false;
    for (int i=0; i<cantElementos() && !esta; i++)
      if (obtenerEntero(i) == n)
        esta = true;
    return esta;
  }

  public int cantidadMayores(int n) {
    int cant = 0;
    for (int i=0; i<cantElementos(); i++)
      if (obtenerEntero(i) > n)
        cant++;
    return cant;
  }

  public boolean mitadMayores(int n) {
    int cant = 0;
    for (int i=0; i<cantElementos() && cant < cantElementos()/2; i++)
      if (obtenerEntero(i) > n)
        cant++;
    return cant >= cantElementos()/2;
  }

  public boolean equals(SecuenciaEnteros a) {
    boolean iguales = true;
    if (cantElementos() == a.cantElementos())
      for (int i=0; i<cantElementos() && iguales; i++)
        if (sec[i] != a.obtenerEntero(i))
          iguales = false;
    return iguales;
  }

  public SecuenciaEnteros clone() {
    SecuenciaEnteros copia = new SecuenciaEnteros(cantElementos());
    copia.copy(this);
    return copia;
  }

  public String toString() {
    String res = "";
    for (int i=0; i<cantElementos(); i++)
      res = res+" "+obtenerEntero(i);
    return res;  
  }
}